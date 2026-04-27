package rpg.state;

import rpg.hero.character.Character;

public class StunnedState implements HeroState {

    public static final int DEFAULT_DURATION_TURNS = 2;

    private static final String NAME = "Stunned";
    private static final int PERCENT_BASE = 100;
    private static final int RECEIVED_DAMAGE_PERCENT = 120;

    private int remainingTurns;

    public StunnedState() {
        this(DEFAULT_DURATION_TURNS);
    }

    public StunnedState(int durationTurns) {
        this.remainingTurns = Math.max(1, durationTurns);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int modifyDamageDealt(Character hero, int baseDamage) {
        return baseDamage;
    }

    @Override
    public int modifyDamageReceived(Character hero, int incomingDamage) {
        return incomingDamage * RECEIVED_DAMAGE_PERCENT / PERCENT_BASE;
    }

    @Override
    public boolean canAttack(Character hero) {
        return false;
    }

    @Override
    public void onTurnStart(Character hero) {
        remainingTurns--;
        if (remainingTurns <= 0 && hero.isAlive()) {
            hero.setState(new NormalState());
        }
    }
}
