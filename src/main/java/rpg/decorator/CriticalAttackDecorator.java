package rpg.decorator;

public class CriticalAttackDecorator extends AttackDecorator {

    public CriticalAttackDecorator(Attack attack) {
        super(attack);
    }

    @Override
    public int dealDamage() {

        int damage = attack.dealDamage();

        System.out.println("Critical hit!");

        return damage * 2;
    }
}