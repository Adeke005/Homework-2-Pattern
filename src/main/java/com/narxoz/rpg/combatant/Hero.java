package com.narxoz.rpg.combatant;

import com.narxoz.rpg.artifact.Artifact;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.memento.HeroMemento;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hero {
    private int hp;
    private int mana;
    private int gold;
    private List<Artifact> inventory;

    public Hero(int hp, int mana, int gold) {
        this(hp, mana, gold, List.of());
    }

    public Hero(int hp, int mana, int gold, List<Artifact> inventory) {
        this.hp = nonNegative(hp, "hp");
        this.mana = nonNegative(mana, "mana");
        this.gold = nonNegative(gold, "gold");
        this.inventory = new ArrayList<>(Objects.requireNonNull(inventory, "inventory must not be null"));
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getGold() {
        return gold;
    }

    public List<Artifact> getInventorySnapshot() {
        return List.copyOf(inventory);
    }

    public Inventory toInventory() {
        return new Inventory(inventory);
    }

    public void addArtifact(Artifact artifact) {
        inventory.add(Objects.requireNonNull(artifact, "artifact must not be null"));
    }

    public void takeDamage(int damage) {
        int safeDamage = nonNegative(damage, "damage");
        hp = Math.max(0, hp - safeDamage);
    }

    public HeroMemento createMemento() {
        return new HeroMemento(hp, mana, gold, inventory);
    }

    public void restoreMemento(HeroMemento memento) {
        Objects.requireNonNull(memento, "memento must not be null");
        memento.restoreTo(this);
    }

    /**
     * Intended for memento restoration only.
     */
    public void restoreFromMemento(int hp, int mana, int gold, List<Artifact> inventorySnapshot) {
        this.hp = nonNegative(hp, "hp");
        this.mana = nonNegative(mana, "mana");
        this.gold = nonNegative(gold, "gold");
        this.inventory = new ArrayList<>(
                Objects.requireNonNull(inventorySnapshot, "inventorySnapshot must not be null"));
    }

    @Override
    public String toString() {
        return "Hero{hp=" + hp + ", mana=" + mana + ", gold=" + gold + ", inventorySize=" + inventory.size() + "}";
    }

    private int nonNegative(int value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " must be non-negative");
        }
        return value;
    }
}
