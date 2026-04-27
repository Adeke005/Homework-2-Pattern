package rpg.state;

import rpg.hero.character.Character;

public class RageState implements HeroState {

    private static final String NAME = "Rage";
    private static final int PERCENT_BASE = 100;
    private static final int DEALT_DAMAGE_PERCENT = 150;
    private static final int RECEIVED_DAMAGE_PERCENT = 90;

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
    public void onHealthChanged(Character hero) {
        if (hero.isAtOrAboveRageThreshold()) {
            hero.setState(new NormalState());
        }
    }
}
