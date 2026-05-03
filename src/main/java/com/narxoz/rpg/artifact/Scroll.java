package com.narxoz.rpg.artifact;

public final class Scroll extends Artifact {
    private final int manaCost;

    public Scroll(int manaCost) {
        if (manaCost < 0) {
            throw new IllegalArgumentException("manaCost must be non-negative");
        }
        this.manaCost = manaCost;
    }

    public int getManaCost() {
        return manaCost;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}
