package com.narxoz.rpg.artifact;

public abstract class Artifact {
    public abstract void accept(ArtifactVisitor visitor);
}
