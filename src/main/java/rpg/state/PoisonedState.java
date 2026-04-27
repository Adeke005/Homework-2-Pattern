package rpg.state;

import rpg.hero.character.Character;

public class PoisonedState implements HeroState {

    public static final int DEFAULT_DURATION_TURNS = 3;
    public static final int DEFAULT_POISON_DAMAGE = 6;

    private static final String NAME = "Poisoned";
    private static final int PERCENT_BASE = 100;
    private static final int DEALT_DAMAGE_PERCENT = 90;
    private static final int RECEIVED_DAMAGE_PERCENT = 110;

    private int remainingTurns;
    private final int poisonDamagePerTurn;

    public PoisonedState() {
        this(DEFAULT_DURATION_TURNS, DEFAULT_POISON_DAMAGE);
    }

    public PoisonedState(int durationTurns, int poisonDamagePerTurn) {
        this.remainingTurns = Math.max(1, durationTurns);
        this.poisonDamagePerTurn = Math.max(0, poisonDamagePerTurn);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int modifyDamageDealt(Character hero, int baseDamage) {
        return baseDamage * DEALT_DAMAGE_PERCENT / PERCENT_BASE;
    }

    @Override
    public int modifyDamageReceived(Character hero, int incomingDamage) {
        return incomingDamage * RECEIVED_DAMAGE_PERCENT / PERCENT_BASE;
    }

    @Override
    public void onTurnStart(Character hero) {
        if (!hero.isAlive()) {
            return;
        }

        hero.applyDirectDamage(poisonDamagePerTurn);
        remainingTurns--;

        System.out.println(hero.getName() + " suffers " + poisonDamagePerTurn
                + " poison damage. Remaining poison turns: " + remainingTurns);

        if (remainingTurns <= 0 && hero.isAlive()) {
            hero.setState(new NormalState());
        }
    }
}
