package com.narxoz.rpg.artifact;

public final class Ring extends Artifact {
    private final int magicPower;

    public Ring(int magicPower) {
        if (magicPower < 0) {
            throw new IllegalArgumentException("magicPower must be non-negative");
        }
        this.magicPower = magicPower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}
