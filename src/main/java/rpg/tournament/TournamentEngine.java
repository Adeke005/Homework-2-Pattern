package rpg.tournament;
import rpg.arena.*;

public class TournamentEngine {

    public void run(ArenaFighter f, ArenaOpponent o) {

        System.out.println("=== TOURNAMENT START ===");

        while (f.getHealth() > 0 && o.getHealth() > 0) {

            o.receiveDamage(f.getAttack());

            f.takeDamage(10);

        }

        System.out.println("Winner: " +
                (f.getHealth() > 0 ? f.getName() : o.getName()));
    }
}