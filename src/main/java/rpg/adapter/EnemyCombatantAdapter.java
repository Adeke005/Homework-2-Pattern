package rpg.adapter;

import rpg.enemy.core.Enemy;
import rpg.strategy.*;
import rpg.observer.*;

public class EnemyCombatantAdapter implements Combatant {

    private final Enemy enemy;

    // --- Strategy ---
    private CombatStrategy strategy = new AggressiveStrategy();

    // --- Phases ---
    private int phase = 1;

    // --- Observer ---
    private EventManager eventManager;

    public EnemyCombatantAdapter(Enemy enemy) {
        this.enemy = enemy;
    }


    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @Override
    public String getName() {
        return enemy.getName();
    }

    @Override
    public int getHealth() {
        return enemy.getStats().getHealth();
    }

    @Override
    public void takeDamage(int damage) {

        int defense = strategy.calculateDefense(enemy.getStats().getDefense());
        int finalDamage = Math.max(0, damage - defense);

        enemy.getStats().setHealth(
                enemy.getStats().getHealth() - finalDamage
        );

        System.out.println(getName() + " takes " + finalDamage + " damage");

        updatePhase();
    }

    @Override
    public int dealDamage() {
        int base = enemy.getStats().getDamage();
        int result = strategy.calculateDamage(base);

        System.out.println(getName() + " deals " + result + " (" + strategy.getName() + ")");
        return result;
    }

    @Override
    public boolean isAlive() {
        return !enemy.isDead();
    }


    private void updatePhase() {

        int hp = enemy.getStats().getHealth();
        int maxHp = 300;

        double percent = (double) hp / maxHp;

        int newPhase;

        if (percent > 0.6) newPhase = 1;
        else if (percent > 0.3) newPhase = 2;
        else newPhase = 3;

        if (newPhase != phase) {
            phase = newPhase;

            switch (phase) {
                case 1 -> strategy = new AggressiveStrategy();
                case 2 -> strategy = new BalancedStrategy();
                case 3 -> strategy = new DefensiveStrategy();
            }

            System.out.println("🔥 Boss phase -> " + phase + " (" + strategy.getName() + ")");

            if (eventManager != null) {
                eventManager.notify(
                        new GameEvent(
                                GameEventType.BOSS_PHASE_CHANGED,
                                getName(),
                                phase
                        )
                );
            }
        }
    }
}