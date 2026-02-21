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

        dragon.setName(name);
        dragon.setType(EnemyType.BOSS);
        dragon.setElement(element);
        dragon.setStats(stats);

        dragon.setAbilities(factory.createAbilities());
        dragon.setLootTable(factory.createLootTable());
        dragon.setAiBehavior(new PhaseBasedAI(phaseThreshold));

        return dragon;
    }
}
