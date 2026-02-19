package rpg.enemy.ai;

public class PhaseBasedAI implements AIBehavior {

    private final int phaseThreshold;
    private int currentHealth;

    public PhaseBasedAI(int phaseThreshold) {
        this.phaseThreshold = phaseThreshold;
    }

    public void updateHealth(int health) {
        this.currentHealth = health;
    }

    @Override
    public void execute() {

        if (currentHealth > phaseThreshold) {
            System.out.println("Boss is in Phase 1: Standard attacks.");
        } else {
            System.out.println("Boss is in Phase 2: Enraged mode activated!");
        }
    }
}
