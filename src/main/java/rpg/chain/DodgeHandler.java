package rpg.chain;

public class DodgeHandler extends DefenseHandler {

    public int handle(int damage) {
        if (Math.random() < 0.2) {
            System.out.println("Dodged!");
            return 0;
        }
        return next.handle(damage);
    }
}