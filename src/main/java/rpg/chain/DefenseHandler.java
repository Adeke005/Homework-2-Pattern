package rpg.chain;

public abstract class DefenseHandler {

    protected DefenseHandler next;

    public void setNext(DefenseHandler next) {
        this.next = next;
    }

    public abstract int handle(int damage);
}