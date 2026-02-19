package rpg.enemy.core;

import rpg.enemy.components.Ability;
import rpg.enemy.components.LootTable;
import rpg.enemy.ai.AIBehavior;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

public abstract class Enemy implements Cloneable {

    protected String name;
    protected EnemyType type;
    protected ElementType element;

    protected Stats stats;

    protected List<Ability> abilities;
    protected LootTable lootTable;
    protected AIBehavior aiBehavior;

    protected Enemy() {
        this.abilities = new ArrayList<>();
    }


    public void performAI() {
        if (aiBehavior != null) {
            aiBehavior.execute();
        }
    }

    public void takeDamage(int amount) {
        int reduced = Math.max(0, amount - stats.getDefense());
        stats.setHealth(stats.getHealth() - reduced);
    }

    public boolean isDead() {
        return stats.getHealth() <= 0;
    }


    @Override
    public Enemy clone() {
        try {
            Enemy clone = (Enemy) super.clone();

            clone.stats = this.stats.clone();
            clone.abilities = new ArrayList<>(this.abilities);


            clone.lootTable = this.lootTable;
            clone.aiBehavior = this.aiBehavior;

            return clone;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }

    public String getName() { return name; }
    public EnemyType getType() { return type; }
    public ElementType getElement() { return element; }
    public Stats getStats() { return stats; }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", element=" + element +
                ", stats=" + stats +
                '}';
    }
}
