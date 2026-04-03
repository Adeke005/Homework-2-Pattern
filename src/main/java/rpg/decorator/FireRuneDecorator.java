package rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {

    public FireRuneDecorator(Attack attack) {
        super(attack);
    }

    @Override
    public int dealDamage() {

        int damage = attack.dealDamage();

        System.out.println("Fire effect added!");

        return damage + 5;
    }
}