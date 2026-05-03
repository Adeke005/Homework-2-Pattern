package com.narxoz.rpg.artifact;

public class DescriptionVisitor implements ArtifactVisitor {
    private final StringBuilder descriptions = new StringBuilder();

    @Override
    public void visit(Weapon weapon) {
        append("Weapon(damage=" + weapon.getBaseDamage() + ")");
    }

    @Override
    public void visit(Potion potion) {
        append("Potion(healing=" + potion.getHealing() + ")");
    }

    @Override
    public void visit(Scroll scroll) {
        append("Scroll(manaCost=" + scroll.getManaCost() + ")");
    }

    @Override
    public void visit(Ring ring) {
        append("Ring(magicPower=" + ring.getMagicPower() + ")");
    }

    @Override
    public void visit(Armor armor) {
        append("Armor(defense=" + armor.getDefense() + ")");
    }

    public String getDescriptions() {
        return descriptions.toString();
    }

    private void append(String value) {
        if (!descriptions.isEmpty()) {
            descriptions.append(System.lineSeparator());
        }
        descriptions.append(value);
    }
}
