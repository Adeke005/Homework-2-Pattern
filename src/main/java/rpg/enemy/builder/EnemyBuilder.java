package rpg.enemy.builder;

import rpg.enemy.core.*;
import rpg.enemy.factory.EnemyComponentFactory;

public abstract class EnemyBuilder {

    protected String name;
    protected EnemyType type;
    protected ElementType element;
    protected Stats stats;

    protected EnemyComponentFactory factory;

    public EnemyBuilder(EnemyComponentFactory factory) {
        this.factory = factory;
    }

    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EnemyBuilder setType(EnemyType type) {
        this.type = type;
        return this;
    }

    public EnemyBuilder setElement(ElementType element) {
        this.element = element;
        return this;
    }

    public EnemyBuilder setStats(Stats stats) {
        this.stats = stats;
        return this;
    }


    public abstract Enemy build();
}
