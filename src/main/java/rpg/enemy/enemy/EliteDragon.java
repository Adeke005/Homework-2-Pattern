package rpg.enemy.enemy;

public class EliteDragon extends DragonBoss {

    private double criticalChance;

    public void setCriticalChance(double chance) {
        this.criticalChance = chance;
    }

    public void performCriticalStrike() {
        System.out.println(name + " performs a critical strike! Chance: " + criticalChance);
    }

    @Override
    public EliteDragon clone() {
        EliteDragon clone = (EliteDragon) super.clone();
        clone.criticalChance = this.criticalChance;
        return clone;
    }
}
