package rpg.floor;

import rpg.hero.character.Character;
import rpg.state.PoisonedState;

public class TrapFloor extends TowerFloor {

    private final int trapDamage;
    private final boolean appliesPoison;
    private final int poisonDurationTurns;
    private final int poisonDamagePerTurn;

    public TrapFloor(String floorName, int trapDamage, boolean appliesPoison,
                     int poisonDurationTurns, int poisonDamagePerTurn) {
        super(floorName);
        this.trapDamage = Math.max(0, trapDamage);
        this.appliesPoison = appliesPoison;
        this.poisonDurationTurns = Math.max(1, poisonDurationTurns);
        this.poisonDamagePerTurn = Math.max(0, poisonDamagePerTurn);
    }

    @Override
    protected void setup(Character hero) {
        System.out.println("A hidden trap is triggered!");
    }

    @Override
    protected FloorResult resolveChallenge(Character hero) {
        hero.startTurn();
        hero.receiveDamage(trapDamage);

        boolean poisonApplied = false;
        if (hero.isAlive() && appliesPoison) {
            hero.setState(new PoisonedState(poisonDurationTurns, poisonDamagePerTurn));
            poisonApplied = true;
        }

        String details = poisonApplied
                ? "Trap dealt " + trapDamage + " damage and applied poison."
                : "Trap dealt " + trapDamage + " damage.";

        return buildResult(hero.isAlive(), details, hero);
    }

    @Override
    protected void cleanup(Character hero, FloorResult result) {
        System.out.println("Trap floor complete: " + result.getDetails());
    }
}
