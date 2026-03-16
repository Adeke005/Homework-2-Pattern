package rpg.decorator;

public abstract class AttackDecorator implements Attack {

    protected Attack attack;

    public AttackDecorator(Attack attack) {
        this.attack = attack;
    }
}