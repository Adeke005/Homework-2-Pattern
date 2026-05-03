package com.narxoz.rpg.artifact;

public final class Armor extends Artifact {
    private final int defense;

    public Armor(int defense) {
        if (defense < 0) {
            throw new IllegalArgumentException("defense must be non-negative");
        }
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}
