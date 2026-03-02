package rpg.battle;

import rpg.adapter.Combatant;

public class BattleEngine {

    private static BattleEngine instance;

    private BattleEngine() {}

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public void startBattle(Combatant a, Combatant b) {

        System.out.println("=================================");
        System.out.println("        BATTLE START");
        System.out.println(a.getName() + " VS " + b.getName());
        System.out.println("=================================\n");

        int round = 1;

        while (a.isAlive() && b.isAlive()) {

            System.out.println("----- Round " + round + " -----");


            int dmgA = a.dealDamage();
            b.takeDamage(dmgA);
            System.out.println(a.getName() + " hits for " + dmgA +
                    " | " + b.getName() + " HP: " + b.getHealth());

            if (!b.isAlive()) break;


            int dmgB = b.dealDamage();
            a.takeDamage(dmgB);
            System.out.println(b.getName() + " hits for " + dmgB +
                    " | " + a.getName() + " HP: " + a.getHealth());


            if (dmgA == 0 && dmgB == 0) {
                System.out.println("Both combatants deal no damage. Battle ends in a draw.");
                return;
            }

            System.out.println();
            round++;
        }

        System.out.println("\n=================================");
        System.out.println("         BATTLE OVER");
        System.out.println("Winner: " +
                (a.isAlive() ? a.getName() : b.getName()));
        System.out.println("=================================");
    }
}