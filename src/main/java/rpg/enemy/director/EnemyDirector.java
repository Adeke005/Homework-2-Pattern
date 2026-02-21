package rpg.enemy.director;

import rpg.enemy.builder.*;
import rpg.enemy.core.*;
import rpg.enemy.factory.*;

public class EnemyDirector {

    public Enemy createStandardFireDragon() {

        EnemyComponentFactory factory = new FireEnemyFactory();

        return new DragonBossBuilder(factory)
                .setName("Fire Dragon")
                .setElement(ElementType.FIRE)
                .setStats(new Stats(50000, 800, 400, 60))
                .build();
    }

    public Enemy createIceGoblin() {

        EnemyComponentFactory factory = new IceEnemyFactory();

        return new GoblinBuilder(factory)
                .setName("Ice Goblin")
                .setElement(ElementType.ICE)
                .setStats(new Stats(1500, 150, 50, 40))
                .build();
    }

    public Enemy createEliteFromTemplate(Enemy base) {

        return new EliteEnemyBuilder(base)
                .increaseStats(5000, 200)
                .build();
    }
}
