package rpg.enemy.factory;

import rpg.enemy.ai.AggressiveAI;
import rpg.enemy.ai.AIBehavior;
import rpg.enemy.components.*;

import java.util.List;

public class FireEnemyFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new Ability("Fire Breath", AbilityType.MAGIC, 500, 10),
                new Ability("Inferno Blast", AbilityType.AREA, 350, 15)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new LootTable(List.of(
                new LootItem("Flame Sword", 0.20),
                new LootItem("Burning Armor", 0.10)
        ));
    }

    @Override
    public AIBehavior createAI() {
        return new AggressiveAI();
    }
}
