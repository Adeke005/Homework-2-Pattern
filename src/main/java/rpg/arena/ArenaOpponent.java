package rpg.arena;

public class ArenaOpponent {

    private String name;
    private int health;

    public ArenaOpponent(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void receiveDamage(int dmg) {
        health -= dmg;
        System.out.println(name + " takes " + dmg + " damage");
    }

    public int getHealth() { return health; }
    public String getName() { return name; }
}