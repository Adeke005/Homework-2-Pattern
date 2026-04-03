package rpg.arena;

public class ArenaFighter {

    private String name;
    private int health;
    private int attack;
    private int defense;

    public ArenaFighter(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public void attack(ArenaOpponent opponent) {
        opponent.receiveDamage(attack);
    }

    public void heal(int amount) {
        health += amount;
        System.out.println(name + " heals +" + amount + " HP");
    }

    public void defend() {
        defense += 5;
        System.out.println(name + " increases defense");
    }

    public void takeDamage(int dmg) {
        health -= dmg;
    }

    public int getHealth() { return health; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public String getName() { return name; }

    public void setHealth(int h) { this.health = h; }
    public void setDefense(int d) { this.defense = d; }
}