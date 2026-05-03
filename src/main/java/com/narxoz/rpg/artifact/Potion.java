package com.narxoz.rpg.artifact;

public final class Potion extends Artifact {
    private final int healing;

    public Potion(int healing) {
        if (healing < 0) {
            throw new IllegalArgumentException("healing must be non-negative");
        }
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}
