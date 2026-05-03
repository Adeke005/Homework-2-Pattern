package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.AppraisalVisitor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import java.util.Objects;

public class ChronomancerEngine {
    private static final int ROLLBACK_THRESHOLD = 50;

    public VaultRunResult run(Hero hero, int trapDamage) {
        Objects.requireNonNull(hero, "hero must not be null");
        if (trapDamage < 0) {
            throw new IllegalArgumentException("trapDamage must be non-negative");
        }

        Caretaker caretaker = new Caretaker();

        caretaker.save(hero);

        Inventory inventory = hero.toInventory();
        AppraisalVisitor appraisalVisitor = new AppraisalVisitor();
        inventory.applyVisitor(appraisalVisitor);

        int hpBeforeTrap = hero.getHp();

        hero.takeDamage(trapDamage);
        int hpAfterTrap = hero.getHp();

        boolean rollbackTriggered = hpAfterTrap < ROLLBACK_THRESHOLD;
        if (rollbackTriggered) {
            caretaker.restore(hero);
        }

        return new VaultRunResult(
                hpBeforeTrap,
                hpAfterTrap,
                hero.getHp(),
                trapDamage,
                appraisalVisitor.getTotalValue(),
                rollbackTriggered);
    }
}
