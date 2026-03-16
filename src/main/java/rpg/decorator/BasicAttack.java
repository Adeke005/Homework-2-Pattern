package rpg.decorator;

public class BasicAttack implements Attack {

    private int baseDamage;

    public BasicAttack(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public int dealDamage() {
        return baseDamage;
    }
}