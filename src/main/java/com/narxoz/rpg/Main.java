package com.narxoz.rpg;

import com.narxoz.rpg.artifact.AppraisalVisitor;
import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.DescriptionVisitor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addArtifact(new Weapon(10));
        inventory.addArtifact(new Potion(20));
        inventory.addArtifact(new Scroll(8));
        inventory.addArtifact(new Ring(6));
        inventory.addArtifact(new Armor(15));

        AppraisalVisitor appraisalVisitor = new AppraisalVisitor();
        inventory.applyVisitor(appraisalVisitor);

        DescriptionVisitor descriptionVisitor = new DescriptionVisitor();
        inventory.applyVisitor(descriptionVisitor);

        System.out.println("=== ARTIFACTS ===");
        System.out.println(descriptionVisitor.getDescriptions());
        System.out.println("Total value: " + appraisalVisitor.getTotalValue() + " gold");

        Hero hero = new Hero(72, 40, 300, inventory.getArtifactsSnapshot());
        ChronomancerEngine engine = new ChronomancerEngine();

        VaultRunResult result = engine.run(hero, 30);

        System.out.println();
        System.out.println("=== VAULT RUN ===");
        System.out.println("Before trap HP: " + result.getHpBeforeTrap());
        System.out.println("After trap HP: " + result.getHpAfterTrap());
        System.out.println("After rollback HP: " + result.getHpAfterRollback());
        System.out.println("Rollback triggered: " + result.isRollbackTriggered());
    }
}
