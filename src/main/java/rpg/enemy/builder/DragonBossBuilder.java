package rpg.enemy.builder;

import rpg.enemy.core.*;
import rpg.enemy.factory.EnemyComponentFactory;
import rpg.enemy.ai.PhaseBasedAI;
import rpg.enemy.enemy.DragonBoss;

public class DragonBossBuilder extends EnemyBuilder {

    private int phaseThreshold;

    public DragonBossBuilder(EnemyComponentFactory factory) {
        super(factory);
    }

    public DragonBossBuilder setPhaseThreshold(int value) {
        this.phaseThreshold = value;
        return this;
    }

    @Override
    public Enemy build() {

        DragonBoss dragon = new DragonBoss();

        dragon.name = name;
        dragon.type = EnemyType.BOSS;
        dragon.element = element;
        dragon.stats = stats;

        dragon.abilities = factory.createAbilities();
        dragon.lootTable = factory.createLootTable();
        dragon.aiBehavior = new PhaseBasedAI(phaseThreshold);

        return dragon;
    }
}
