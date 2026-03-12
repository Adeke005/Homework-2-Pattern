package rpg.raid;

public class RaidEngine {

    public void startRaid(CombatNode a, CombatNode b) {

        int round = 1;

        System.out.println("=== RAID START ===");

        while (a.isAlive() && b.isAlive()) {

            System.out.println("Round " + round);

            int dmgA = a.dealDamage();
            b.takeDamage(dmgA);

            if (!b.isAlive()) break;

            int dmgB = b.dealDamage();
            a.takeDamage(dmgB);

            round++;
        }

        System.out.println("Winner: " +
                (a.isAlive() ? a.getName() : b.getName()));
    }
}