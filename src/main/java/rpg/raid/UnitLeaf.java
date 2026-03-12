package rpg.raid;


import rpg.adapter.Combatant;

public class UnitLeaf implements CombatNode {

    private Combatant combatant;

    public UnitLeaf(Combatant combatant) {
        this.combatant = combatant;
    }

    public String getName() {
        return combatant.getName();
    }

    public int getHealth() {
        return combatant.getHealth();
    }

    public int dealDamage() {
        return combatant.dealDamage();
    }

    public void takeDamage(int damage) {
        combatant.takeDamage(damage);
    }

    public boolean isAlive() {
        return combatant.isAlive();
    }
}