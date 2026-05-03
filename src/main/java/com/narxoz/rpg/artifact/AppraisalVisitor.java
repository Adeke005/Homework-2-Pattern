package com.narxoz.rpg.artifact;

public class AppraisalVisitor implements ArtifactVisitor {
    private int totalValue;

    @Override
    public void visit(Weapon weapon) {
        totalValue += weapon.getBaseDamage() * 10;
    }

    @Override
    public void visit(Potion potion) {
        totalValue += potion.getHealing() * 5;
    }

    @Override
    public void visit(Scroll scroll) {
        totalValue += scroll.getManaCost() * 7;
    }

    @Override
    public void visit(Ring ring) {
        totalValue += ring.getMagicPower() * 12;
    }

    @Override
    public void visit(Armor armor) {
        totalValue += armor.getDefense() * 8;
    }

    public int getTotalValue() {
        return totalValue;
    }
}
