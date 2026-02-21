package rpg.enemy.enemy;

import rpg.enemy.core.Enemy;

public class DragonBoss extends Enemy {

    private int phaseThreshold;
    private boolean enraged;

    public void setPhaseThreshold(int threshold) {
        this.phaseThreshold = threshold;
    }

    public void checkPhase() {
        if (stats.getHealth() <= phaseThreshold && !enraged) {
            enraged = true;
            System.out.println(name + " has entered ENRAGED phase!");
        }
    }

    @Override
    public DragonBoss clone() {
        DragonBoss clone = (DragonBoss) super.clone();
        clone.enraged = this.enraged;
        return clone;
    }
}
