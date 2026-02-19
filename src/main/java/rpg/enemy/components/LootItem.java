package rpg.enemy.components;

public class LootItem {

    private final String name;
    private final double dropChance;

    public LootItem(String name, double dropChance) {
        this.name = name;
        this.dropChance = dropChance;
    }

    public String getName() { return name; }
    public double getDropChance() { return dropChance; }

    @Override
    public String toString() {
        return name + " (" + (dropChance * 100) + "%)";
    }
}
