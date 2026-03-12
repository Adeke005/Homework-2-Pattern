package rpg.raid;


import java.util.ArrayList;
import java.util.List;

public class RaidGroup implements CombatNode {

    private String name;
    private List<CombatNode> members = new ArrayList<>();

    public RaidGroup(String name) {
        this.name = name;
    }

    public void add(CombatNode node) {
        members.add(node);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        int total = 0;

        for (CombatNode m : members) {
            total += m.getHealth();
        }

        return total;
    }

    public int dealDamage() {

        int total = 0;

        for (CombatNode m : members) {
            if (m.isAlive()) {
                total += m.dealDamage();
            }
        }

        return total;
    }

    public void takeDamage(int damage) {

        int split = damage / members.size();

        for (CombatNode m : members) {
            if (m.isAlive()) {
                m.takeDamage(split);
            }
        }
    }

    public boolean isAlive() {

        for (CombatNode m : members) {
            if (m.isAlive()) {
                return true;
            }
        }

        return false;
    }
}
