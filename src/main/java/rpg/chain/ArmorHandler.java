package rpg.chain;

public class ArmorHandler extends DefenseHandler {

    public int handle(int damage) {
        System.out.println("Armor reduced 3 damage");
        return next.handle(damage - 3);
    }
}