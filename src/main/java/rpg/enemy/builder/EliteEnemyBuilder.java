package rpg.enemy.builder;

import rpg.enemy.core.Enemy;
import rpg.enemy.core.EnemyType;
import rpg.enemy.core.Stats;

public class EliteEnemyBuilder {

    private final Enemy baseEnemy;

    public EliteEnemyBuilder(Enemy baseEnemy) {
        this.baseEnemy = baseEnemy.clone(); // Prototype
    }

    public EliteEnemyBuilder increaseStats(int healthBonus, int damageBonus) {

        Stats stats = baseEnemy.getStats();

        stats.setHealth(stats.getHealth() + healthBonus);
        stats.setDamage(stats.getDamage() + damageBonus);

        baseEnemy.type = EnemyType.ELITE;

        return this;
    }

    public Enemy build() {
        return baseEnemy;
    }
}
