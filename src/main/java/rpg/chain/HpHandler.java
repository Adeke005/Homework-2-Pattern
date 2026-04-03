package rpg.chain;

public class HpHandler extends DefenseHandler {

    public int handle(int damage) {
        return Math.max(0, damage);
    }
}