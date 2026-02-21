package rpg.enemy.enemy;

import rpg.enemy.core.Enemy;

public class Goblin extends Enemy {

    public void steal() {
        System.out.println(name + " attempts to steal gold!");
    }

    @Override
    public Goblin clone() {
        return (Goblin) super.clone();
    }
}
