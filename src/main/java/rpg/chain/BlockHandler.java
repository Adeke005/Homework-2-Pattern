package rpg.chain;

public class BlockHandler extends DefenseHandler {

    public int handle(int damage) {
        System.out.println("Blocked 5 damage");
        return next.handle(damage - 5);
    }
}
