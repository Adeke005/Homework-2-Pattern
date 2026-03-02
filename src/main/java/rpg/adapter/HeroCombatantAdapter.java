package rpg.adapter;

import rpg.hero.character.Character;

public class HeroCombatantAdapter implements Combatant {

    private final Character hero;

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
        int damage = hero.attack();

        System.out.println(hero.getName() +
                " attacks for " + damage + " damage.");

        return damage;
    }

    @Override
    public boolean isAlive() {
        return hero.isAlive();
    }
}
