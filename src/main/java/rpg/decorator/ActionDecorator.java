package rpg.decorator;

public abstract class ActionDecorator implements Attack {

    protected Attack attack;

    public ActionDecorator(Attack attack) {
        this.attack = attack;
    }

    @Override
    public int dealDamage() {
        return attack.dealDamage(); // делегирование
    }
}