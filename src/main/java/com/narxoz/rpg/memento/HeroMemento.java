package com.narxoz.rpg.memento;

import com.narxoz.rpg.artifact.Artifact;
import com.narxoz.rpg.combatant.Hero;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class HeroMemento {
    private final int hp;
    private final int mana;
    private final int gold;
    private final List<Artifact> inventory;

    public HeroMemento(int hp, int mana, int gold, List<Artifact> inventory) {
        this.hp = hp;
        this.mana = mana;
        this.gold = gold;
        this.inventory = List.copyOf(new ArrayList<>(Objects.requireNonNull(inventory, "inventory must not be null")));
    }

    int getHp() {
        return hp;
    }

    int getMana() {
        return mana;
    }

    int getGold() {
        return gold;
    }

    List<Artifact> getInventory() {
        return inventory;
    }

    public void restoreTo(Hero hero) {
        Objects.requireNonNull(hero, "hero must not be null");
        hero.restoreFromMemento(getHp(), getMana(), getGold(), getInventory());
    }
}
