package rpg.enemy.builder;

import rpg.enemy.core.*;
import rpg.enemy.factory.EnemyComponentFactory;
import rpg.enemy.enemy.Goblin;

public class GoblinBuilder extends EnemyBuilder {

    public GoblinBuilder(EnemyComponentFactory factory) {
        super(factory);
    }

    @Override
    public Enemy build() {

        Goblin goblin = new Goblin();

        goblin.name = name;
        goblin.type = EnemyType.NORMAL;
        goblin.element = element;
        goblin.stats = stats;

        goblin.abilities = factory.createAbilities();
        goblin.lootTable = factory.createLootTable();
        goblin.aiBehavior = factory.createAI();

        return goblin;
    }
}
