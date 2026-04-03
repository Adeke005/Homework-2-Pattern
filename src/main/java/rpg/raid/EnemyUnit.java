package rpg.raid;

import rpg.adapter.Combatant;

public class EnemyUnit implements CombatNode {

    private final Combatant enemy;

    public EnemyUnit(Combatant enemy) {
        this.enemy = enemy;
    }

    public String getName() {
        return enemy.getName();
    }

    public int getHealth() {
        return enemy.getHealth();
    }

    public int dealDamage() {
        return enemy.dealDamage();
    }

    public void takeDamage(int damage) {
        enemy.takeDamage(damage);
    }

    public boolean isAlive() {
        return enemy.isAlive();
    }
}