package rpg.state;

import rpg.hero.character.Character;

public class NormalState implements HeroState {

    private static final String NAME = "Normal";

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
        return incomingDamage;
    }

    @Override
    public void onHealthChanged(Character hero) {
        if (hero.isBelowRageThreshold()) {
            hero.setState(new RageState());
        }
    }
}
