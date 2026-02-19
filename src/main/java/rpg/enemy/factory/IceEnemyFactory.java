package rpg.enemy.factory;

import rpg.enemy.ai.DefensiveAI;
import rpg.enemy.ai.AIBehavior;
import rpg.enemy.components.*;

import java.util.List;

public class IceEnemyFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new Ability("Ice Shard", AbilityType.MAGIC, 400, 8),
                new Ability("Frost Nova", AbilityType.CONTROL, 300, 12)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new LootTable(List.of(
                new LootItem("Ice Staff", 0.25),
                new LootItem("Frozen Shield", 0.15)
        ));
    }

    @Override
    public AIBehavior createAI() {
        return new DefensiveAI();
    }
}
