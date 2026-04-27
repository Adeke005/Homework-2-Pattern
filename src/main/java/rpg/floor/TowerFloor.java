package rpg.floor;

import rpg.hero.character.Character;

public abstract class TowerFloor {

    private final String floorName;

    protected TowerFloor(String floorName) {
        this.floorName = floorName;
    }

    public final FloorResult explore(Character hero) {
        announce(hero);
        setup(hero);
        FloorResult result = resolveChallenge(hero);
        awardLoot(hero, result);
        cleanup(hero, result);
        return result;
    }

    protected void announce(Character hero) {
        System.out.println("\n[Floor] " + floorName + " | Hero state: " + hero.getCurrentStateName());
    }

    protected void setup(Character hero) {
        // optional hook
    }

    protected abstract FloorResult resolveChallenge(Character hero);

    protected void awardLoot(Character hero, FloorResult result) {
        // optional hook
    }

    protected void cleanup(Character hero, FloorResult result) {
        // optional hook
    }

    protected final FloorResult buildResult(boolean success, String details, Character hero) {
        return new FloorResult(floorName, success, details, hero.getHealth());
    }

    public String getFloorName() {
        return floorName;
    }
}
