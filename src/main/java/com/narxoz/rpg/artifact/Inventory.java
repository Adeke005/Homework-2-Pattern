package com.narxoz.rpg.artifact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private final List<Artifact> artifacts;

    public Inventory() {
        this.artifacts = new ArrayList<>();
    }

    public Inventory(List<Artifact> artifacts) {
        this.artifacts = new ArrayList<>(Objects.requireNonNull(artifacts, "artifacts must not be null"));
    }

    public void addArtifact(Artifact artifact) {
        artifacts.add(Objects.requireNonNull(artifact, "artifact must not be null"));
    }

    public List<Artifact> getArtifactsSnapshot() {
        return List.copyOf(artifacts);
    }

    public void applyVisitor(ArtifactVisitor visitor) {
        Objects.requireNonNull(visitor, "visitor must not be null");
        for (Artifact artifact : artifacts) {
            artifact.accept(visitor);
        }
    }
}
