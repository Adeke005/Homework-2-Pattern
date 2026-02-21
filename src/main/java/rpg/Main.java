package rpg;

import rpg.enemy.core.Enemy;
import rpg.enemy.director.EnemyDirector;
import rpg.enemy.prototype.EnemyRegistry;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG Enemy System Demo ===\n");

        EnemyDirector director = new EnemyDirector();


        System.out.println("Creating Fire Dragon Boss...");
        Enemy fireDragon = director.createStandardFireDragon();
        System.out.println(fireDragon);
        fireDragon.performAI();

        System.out.println("\n----------------------------------\n");


        System.out.println("Creating Ice Goblin...");
        Enemy iceGoblin = director.createIceGoblin();
        System.out.println(iceGoblin);
        iceGoblin.performAI();

        System.out.println("\n----------------------------------\n");


        System.out.println("Registering Fire Dragon template...");
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("fire_dragon", fireDragon);

        System.out.println("Cloning Fire Dragon from registry...");
        Enemy clonedDragon = registry.create("fire_dragon");
        System.out.println("Cloned: " + clonedDragon);

        System.out.println("\n----------------------------------\n");


        System.out.println("Creating Elite version of Fire Dragon...");
        Enemy eliteDragon = director.createEliteFromTemplate(clonedDragon);
        System.out.println("Elite: " + eliteDragon);

        System.out.println("\n----------------------------------\n");


        System.out.println("Damaging Elite Dragon...");
        eliteDragon.takeDamage(10000);

        System.out.println("Original Dragon HP: " + fireDragon.getStats().getHealth());
        System.out.println("Elite Dragon HP: " + eliteDragon.getStats().getHealth());

        System.out.println("\n=== Demo Finished ===");
    }
}
