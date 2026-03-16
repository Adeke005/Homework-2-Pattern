package rpg.decorator;

public class FireAttackDecorator extends AttackDecorator {

    public FireAttackDecorator(Attack attack) {
        super(attack);
    }

    @Override
    public int dealDamage() {

        int damage = attack.dealDamage();

        System.out.println("Fire effect added!");

        return damage + 5;
    }
}