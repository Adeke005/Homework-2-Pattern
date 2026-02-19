package rpg.enemy.core;

public class Stats implements Cloneable {

    private int health;
    private int damage;
    private int defense;
    private int speed;

    public Stats(int health, int damage, int defense, int speed) {
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
    }


    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }


    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setSpeed(int speed) { this.speed = speed; }

    @Override
    public Stats clone() {
        return new Stats(health, damage, defense, speed);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "health=" + health +
                ", damage=" + damage +
                ", defense=" + defense +
                ", speed=" + speed +
                '}';
    }
}
