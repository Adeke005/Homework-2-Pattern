package rpg.adapter;
import rpg.strategy.*;

import rpg.hero.character.Character;

public class HeroCombatantAdapter implements Combatant {

    private final Character hero;
    private CombatStrategy strategy = new BalancedStrategy();

    public HeroCombatantAdapter(Character hero) {
        this.hero = hero;
    }

    @Override
    public String getName() {
        return hero.getName();
    }

    @Override
    public int getHealth() {
        return hero.getHealth();
    }

    @Override
    public void takeDamage(int damage) {
        hero.receiveDamage(damage);

        System.out.println(hero.getName() +
                " receives damage. Remaining HP: " + hero.getHealth());
    }

    @Override
    public int dealDamage() {
        int base = hero.attack();
        int result = strategy.calculateDamage(base);

        System.out.println(hero.getName() +
                " attacks for " + result + " (" + strategy.getName() + ")");
        return result;
    }

    @Override
    public boolean isAlive() {
        return hero.isAlive();
    }
}
