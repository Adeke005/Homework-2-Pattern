package rpg.floor;

import rpg.hero.character.Character;

public class TreasureFloor extends TowerFloor {

    private final String rewardName;
    private final int healAmount;

    public TreasureFloor(String floorName, String rewardName, int healAmount) {
        super(floorName);
        this.rewardName = rewardName;
        this.healAmount = Math.max(0, healAmount);
    }

    @Override
    protected FloorResult resolveChallenge(Character hero) {
        hero.startTurn();
        hero.heal(healAmount);

        String details = "Collected " + rewardName + " and restored " + healAmount + " HP";
        return buildResult(true, details, hero);
    }

    @Override
    protected void cleanup(Character hero, FloorResult result) {
        System.out.println("Treasure secured: " + rewardName);
    }
}
