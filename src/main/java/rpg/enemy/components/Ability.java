package rpg.enemy.components;

public class Ability {

    private final String name;
    private final AbilityType type;
    private final int power;
    private final int cooldown;

    public Ability(String name, AbilityType type, int power, int cooldown) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.cooldown = cooldown;
    }

    public String getName() { return name; }
    public AbilityType getType() { return type; }
    public int getPower() { return power; }
    public int getCooldown() { return cooldown; }

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", power=" + power +
                ", cooldown=" + cooldown +
                '}';
    }
}
