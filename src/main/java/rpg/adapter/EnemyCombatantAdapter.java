package rpg.adapter;


import rpg.enemy.core.Enemy;

public class EnemyCombatantAdapter implements Combatant {

    private final Enemy enemy;

    public EnemyCombatantAdapter(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public String getName() {
        return enemy.getName();
    }

    @Override
    public int getHealth() {
        return enemy.getStats().getHealth();
    }

    @Override
    public void takeDamage(int damage) {
        enemy.takeDamage(damage);
    }

    @Override
    public int dealDamage() {
        return enemy.getStats().getDamage();
    }

    @Override
    public boolean isAlive() {
        return !enemy.isDead();
    }
}
