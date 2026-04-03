package rpg.decorator;

public class PoisonAttackDecorator extends ActionDecorator {

    public PoisonAttackDecorator(Attack attack) {
        super(attack);
    }

    @Override
    public int dealDamage() {

        int damage = attack.dealDamage();

        System.out.println("Poison damage added!");

        return damage + 3;
    }
}