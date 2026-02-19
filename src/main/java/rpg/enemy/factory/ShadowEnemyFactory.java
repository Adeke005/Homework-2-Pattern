package rpg.enemy.factory;

import rpg.enemy.ai.AggressiveAI;
import rpg.enemy.ai.AIBehavior;
import rpg.enemy.components.*;

import java.util.List;

public class ShadowEnemyFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new Ability("Shadow Strike", AbilityType.PHYSICAL, 450, 6),
                new Ability("Curse", AbilityType.DOT, 250, 10)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new LootTable(List.of(
                new LootItem("Shadow Dagger", 0.30),
                new LootItem("Dark Cloak", 0.18)
        ));
    }

    @Override
    public AIBehavior createAI() {
        return new AggressiveAI();
    }
}
