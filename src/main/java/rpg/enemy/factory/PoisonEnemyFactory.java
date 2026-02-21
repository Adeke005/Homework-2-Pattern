package rpg.enemy.factory;

import rpg.enemy.ai.DefensiveAI;
import rpg.enemy.ai.AIBehavior;
import rpg.enemy.components.*;

import java.util.List;

public class PoisonEnemyFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new Ability("Venom Bite", AbilityType.DOT, 300, 5),
                new Ability("Toxic Cloud", AbilityType.AREA, 280, 12)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new LootTable(List.of(
                new LootItem("Poison Fang", 0.22),
                new LootItem("Toxic Armor", 0.12)
        ));
    }

    @Override
    public AIBehavior createAI() {
        return new DefensiveAI();
    }
}
