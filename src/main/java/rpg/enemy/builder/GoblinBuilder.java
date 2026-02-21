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

        goblin.setName(name);
        goblin.setType(EnemyType.NORMAL);
        goblin.setElement(element);
        goblin.setStats(stats);

        goblin.setAbilities(factory.createAbilities());
        goblin.setLootTable(factory.createLootTable());
        goblin.setAiBehavior(factory.createAI());

        return goblin;
    }

}
