package rpg.observer;


public enum GameEventType {

    /** Fired when any combatant successfully lands an attack. */
    ATTACK_LANDED,

    /** Fired when a hero's HP drops below 30% of their maximum HP. */
    HERO_LOW_HP,

    /** Fired when a hero's HP reaches zero. */
    HERO_DIED,

    /** Fired when the boss crosses a HP phase threshold (60% or 30%). */
    BOSS_PHASE_CHANGED,

    /** Fired when the boss's HP reaches zero. */
    BOSS_DEFEATED
}
