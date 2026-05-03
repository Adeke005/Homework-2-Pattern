package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.Hero;
import java.util.Objects;
import java.util.Stack;

public class Caretaker {
    private final Stack<HeroMemento> history = new Stack<>();

    public void save(Hero hero) {
        Objects.requireNonNull(hero, "hero must not be null");
        history.push(hero.createMemento());
    }

    public void restore(Hero hero) {
        Objects.requireNonNull(hero, "hero must not be null");
        if (history.isEmpty()) {
            return;
        }
        hero.restoreMemento(history.pop());
    }
}
