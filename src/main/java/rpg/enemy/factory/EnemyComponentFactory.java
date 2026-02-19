package rpg.enemy.factory;

import rpg.enemy.components.Ability;
import rpg.enemy.components.LootTable;
import rpg.enemy.ai.AIBehavior;

import java.util.List;

public interface EnemyComponentFactory {

    List<Ability> createAbilities();

    LootTable createLootTable();

    AIBehavior createAI();
}
