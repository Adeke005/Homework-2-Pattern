package rpg.floor;

import rpg.hero.character.Character;

public class BattleFloor extends TowerFloor {

    private static final int VICTORY_HEAL = 10;

    private final String monsterName;
    private final int monsterMaxHp;
    private final int monsterDamage;

    public BattleFloor(String floorName, String monsterName, int monsterMaxHp, int monsterDamage) {
        super(floorName);
        this.monsterName = monsterName;
        this.monsterMaxHp = Math.max(1, monsterMaxHp);
        this.monsterDamage = Math.max(0, monsterDamage);
    }

    @Override
    protected void setup(Character hero) {
        System.out.println(monsterName + " appears with HP: " + monsterMaxHp);
    }

    @Override
    protected FloorResult resolveChallenge(Character hero) {
        int monsterHp = monsterMaxHp;
        int round = 1;

        while (hero.isAlive() && monsterHp > 0) {
            System.out.println("Battle round " + round);

            hero.startTurn();
            if (!hero.isAlive()) {
                break;
            }

            int heroDamage = hero.attack();
            monsterHp = Math.max(0, monsterHp - heroDamage);
            System.out.println(hero.getName() + " deals " + heroDamage
                    + " to " + monsterName + ". Monster HP: " + monsterHp);

            if (monsterHp <= 0) {
                break;
            }

            hero.receiveDamage(monsterDamage);
            System.out.println(monsterName + " deals " + monsterDamage
                    + " to " + hero.getName() + ". Hero HP: " + hero.getHealth());
            round++;
        }

        boolean heroWon = hero.isAlive() && monsterHp == 0;
        String details = heroWon ? "Defeated " + monsterName : "Defeated by " + monsterName;
        return buildResult(heroWon, details, hero);
    }

    @Override
    protected void awardLoot(Character hero, FloorResult result) {
        if (result.isSuccess() && hero.isAlive()) {
            hero.heal(VICTORY_HEAL);
            System.out.println("Victory reward: +" + VICTORY_HEAL + " HP");
        }
    }

    @Override
    protected void cleanup(Character hero, FloorResult result) {
        System.out.println("Battle floor complete: " + result.getDetails());
    }
}
