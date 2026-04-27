package rpg.state;

import rpg.hero.character.Character;

public interface HeroState {

    String getName();

    int modifyDamageDealt(Character hero, int baseDamage);

    int modifyDamageReceived(Character hero, int incomingDamage);

    default boolean canAttack(Character hero) {
        return true;
    }

    default void onTurnStart(Character hero) {
    }

    default void onAfterDamageTaken(Character hero, int finalDamage) {
    }

    default void onHealthChanged(Character hero) {
    }
}
