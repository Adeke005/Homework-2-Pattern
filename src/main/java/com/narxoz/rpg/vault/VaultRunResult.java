package com.narxoz.rpg.vault;

public final class VaultRunResult {
    private final int hpBeforeTrap;
    private final int hpAfterTrap;
    private final int hpAfterRollback;
    private final int trapDamage;
    private final int totalArtifactValue;
    private final boolean rollbackTriggered;

    public VaultRunResult(
            int hpBeforeTrap,
            int hpAfterTrap,
            int hpAfterRollback,
            int trapDamage,
            int totalArtifactValue,
            boolean rollbackTriggered) {
        this.hpBeforeTrap = hpBeforeTrap;
        this.hpAfterTrap = hpAfterTrap;
        this.hpAfterRollback = hpAfterRollback;
        this.trapDamage = trapDamage;
        this.totalArtifactValue = totalArtifactValue;
        this.rollbackTriggered = rollbackTriggered;
    }

    public int getHpBeforeTrap() {
        return hpBeforeTrap;
    }

    public int getHpAfterTrap() {
        return hpAfterTrap;
    }

    public int getHpAfterRollback() {
        return hpAfterRollback;
    }

    public int getTrapDamage() {
        return trapDamage;
    }

    public int getTotalArtifactValue() {
        return totalArtifactValue;
    }

    public boolean isRollbackTriggered() {
        return rollbackTriggered;
    }
}
