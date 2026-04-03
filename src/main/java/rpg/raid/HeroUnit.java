package rpg.raid;

import rpg.adapter.Combatant;

public class HeroUnit implements CombatNode {

    private final Combatant hero;

    public HeroUnit(Combatant hero) {
        this.hero = hero;
    }

    public String getName() {
        return hero.getName();
    }

    public int getHealth() {
        return hero.getHealth();
    }

    public int dealDamage() {
        return hero.dealDamage();
    }

    public void takeDamage(int damage) {
        hero.takeDamage(damage);
    }

    public boolean isAlive() {
        return hero.isAlive();
    }
}