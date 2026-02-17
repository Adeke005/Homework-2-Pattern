package rpg.enemy;

import rpg.enemy.components.*;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractEnemy implements Enemy {

    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int speed;

    protected Attributes attributes;
    protected List<Ability> abilities;
    protected LootTable lootTable;
    protected AIBehavior aiBehavior;

    protected AbstractEnemy() {
        this.abilities = new ArrayList<>();
    }

    protected AbstractEnemy(AbstractEnemy other) {
        this.name = other.name;
        this.health = other.health;
        this.attack = other.attack;
        this.defense = other.defense;
        this.speed = other.speed;
        this.attributes = other.attributes == null ? null : new Attributes(other.attributes);
        this.abilities = new ArrayList<>();
        for (Ability a : other.abilities) this.abilities.add(a.clone());
        this.lootTable = other.lootTable == null ? null : other.lootTable.clone();
        this.aiBehavior = other.aiBehavior == null ? null : other.aiBehavior.clone();
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getAttack() { return attack; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }

    @Override
    public void takeDamage(int rawDamage) {
        int reduced = rawDamage - defense;
        int finalDamage = Math.max(0, reduced);
        health = Math.max(0, health - finalDamage);
    }

    @Override
    public void performAIAction() {
        if (aiBehavior != null) aiBehavior.act(this);
    }

    @Override
    public String toString() {
        return "%s [HP=%d ATK=%d DEF=%d SPD=%d abilities=%d]"
                .formatted(name, health, attack, defense, speed, abilities.size());
    }
}

