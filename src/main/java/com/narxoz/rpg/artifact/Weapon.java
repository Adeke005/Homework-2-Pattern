package com.narxoz.rpg.artifact;

public final class Weapon extends Artifact {
    private final int baseDamage;

    public Weapon(int baseDamage) {
        if (baseDamage < 0) {
            throw new IllegalArgumentException("baseDamage must be non-negative");
        }
        this.baseDamage = baseDamage;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}
