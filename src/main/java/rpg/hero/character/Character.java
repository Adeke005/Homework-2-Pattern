package rpg.hero.character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import rpg.hero.equipment.Armor;
import rpg.hero.equipment.EquipmentFactory;
import rpg.hero.equipment.Weapon;
import rpg.state.HeroState;
import rpg.state.NormalState;

public abstract class Character {

    private static final int ZERO = 0;
    private static final int PERCENT_BASE = 100;
    private static final int RAGE_THRESHOLD_PERCENT = 30;

    protected String name;
    protected int health;
    protected int attack;

    protected Weapon weapon;
    protected Armor armor;

    private int maxHealth;
    private HeroState currentState = new NormalState();
    private final List<String> stateTransitionLog = new ArrayList<>();

    public void equip(EquipmentFactory factory) {
        this.weapon = factory.createWeapon();
        this.armor = factory.createArmor();
    }



    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        ensureMaxHealthInitialized();
        return maxHealth;
    }

    public boolean isAlive() {
        return health > ZERO;
    }

    public HeroState getCurrentState() {
        return currentState;
    }

    public String getCurrentStateName() {
        return currentState.getName();
    }

    public List<String> getStateTransitionLog() {
        return Collections.unmodifiableList(stateTransitionLog);
    }

    public void setState(HeroState newState) {
        HeroState validatedState = Objects.requireNonNull(newState, "Hero state cannot be null");
        if (currentState.getClass().equals(validatedState.getClass())) {
            return;
        }
        String transition = name + " state: " + currentState.getName() + " -> " + validatedState.getName();
        currentState = validatedState;
        stateTransitionLog.add(transition);
        System.out.println(transition);
    }

    public void startTurn() {
        currentState.onTurnStart(this);
    }

    public int attack() {
        if (!isAlive()) {
            return ZERO;
        }

        if (!currentState.canAttack(this)) {
            System.out.println(name + " cannot attack while in " + currentState.getName() + ".");
            return ZERO;
        }

        int weaponBonus = (weapon != null) ? weapon.getAttackBonus() : 0;
        int baseDamage = attack + weaponBonus;
        return Math.max(ZERO, currentState.modifyDamageDealt(this, baseDamage));
    }


    public void receiveDamage(int damage) {
        ensureMaxHealthInitialized();

        int adjustedDamage = Math.max(ZERO,
                currentState.modifyDamageReceived(this, Math.max(ZERO, damage)));
        int defense = (armor != null) ? armor.getDefenseBonus() : 0;
        int finalDamage = Math.max(ZERO, adjustedDamage - defense);

        applyDamage(finalDamage);
        currentState.onAfterDamageTaken(this, finalDamage);
        currentState.onHealthChanged(this);
    }

    public void applyDirectDamage(int damage) {
        ensureMaxHealthInitialized();

        int finalDamage = Math.max(ZERO, damage);
        applyDamage(finalDamage);
        currentState.onAfterDamageTaken(this, finalDamage);
        currentState.onHealthChanged(this);
    }

    public void heal(int amount) {
        ensureMaxHealthInitialized();

        int recovery = Math.max(ZERO, amount);
        health = Math.min(maxHealth, health + recovery);
        currentState.onHealthChanged(this);
    }

    public boolean isBelowRageThreshold() {
        ensureMaxHealthInitialized();
        return isAlive() && (health * PERCENT_BASE < maxHealth * RAGE_THRESHOLD_PERCENT);
    }

    public boolean isAtOrAboveRageThreshold() {
        ensureMaxHealthInitialized();
        return health * PERCENT_BASE >= maxHealth * RAGE_THRESHOLD_PERCENT;
    }

    public void showStats() {

        System.out.println("===== CHARACTER =====");
        System.out.println("Name: " + name);
        System.out.println("HP: " + health);
        System.out.println("Base ATK: " + attack);

        if (weapon != null) {
            System.out.println("Weapon: " + weapon.getName()
                    + " (+" + weapon.getAttackBonus() + " ATK)");
        }

        if (armor != null) {
            System.out.println("Armor: " + armor.getName()
                    + " (+" + armor.getDefenseBonus() + " DEF)");
        }

        System.out.println("State: " + currentState.getName());
        System.out.println("=====================");
    }

    private void ensureMaxHealthInitialized() {
        if (maxHealth <= ZERO) {
            maxHealth = Math.max(health, 1);
        }
    }

    private void applyDamage(int amount) {
        health = Math.max(ZERO, health - amount);
    }
}
