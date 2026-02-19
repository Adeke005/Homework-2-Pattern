package rpg.enemy.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootTable {

    private final List<LootItem> items;
    private final Random random = new Random();

    public LootTable(List<LootItem> items) {
        this.items = new ArrayList<>(items);
    }

    public List<LootItem> rollLoot() {
        List<LootItem> dropped = new ArrayList<>();

        for (LootItem item : items) {
            if (random.nextDouble() <= item.getDropChance()) {
                dropped.add(item);
            }
        }

        return dropped;
    }

    public List<LootItem> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public String toString() {
        return "LootTable{" +
                "items=" + items +
                '}';
    }
}
