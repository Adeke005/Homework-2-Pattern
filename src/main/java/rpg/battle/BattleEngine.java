package rpg.battle;

import rpg.adapter.Combatant;
import rpg.observer.GameEventType;
import rpg.observer.EventManager;
import rpg.observer.GameEvent;



public class BattleEngine {

    private static BattleEngine instance;
    private EventManager eventManager;

    private BattleEngine() {}

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }
    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
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


            eventManager.notify(
                    new GameEvent(GameEventType.ATTACK_LANDED, a.getName(), dmgA)
            );

            if (!b.isAlive()) {
                eventManager.notify(
                        new GameEvent(GameEventType.HERO_DIED, b.getName(), 0)
                );
                break;
            }

            int dmgB = b.dealDamage();
            a.takeDamage(dmgB);

            System.out.println(b.getName() + " hits for " + dmgB +
                    " | " + a.getName() + " HP: " + a.getHealth());


            eventManager.notify(
                    new GameEvent(GameEventType.ATTACK_LANDED, b.getName(), dmgB)
            );

            if (a.getHealth() < 30) {
                eventManager.notify(
                        new GameEvent(GameEventType.HERO_LOW_HP, a.getName(), a.getHealth())
                );
            }

            if (!a.isAlive()) {
                eventManager.notify(
                        new GameEvent(GameEventType.HERO_DIED, a.getName(), 0)
                );
            }

            if (dmgA == 0 && dmgB == 0) {
                System.out.println("Both combatants deal no damage. Battle ends in a draw.");
                return;
            }

            System.out.println();
            round++;
        }

        if (eventManager != null) {
            eventManager.notify(
                    new GameEvent(GameEventType.BOSS_DEFEATED,
                            (a.isAlive() ? a.getName() : b.getName()),
                            0)
            );
        }

        System.out.println("\n=================================");
        System.out.println("         BATTLE OVER");
        System.out.println("Winner: " +
                (a.isAlive() ? a.getName() : b.getName()));
        System.out.println("=================================");
    }

}