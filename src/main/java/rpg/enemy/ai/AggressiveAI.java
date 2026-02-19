package rpg.enemy.ai;

public class AggressiveAI implements AIBehavior {

    @Override
    public void execute() {
        System.out.println("Enemy attacks aggressively with maximum damage!");
    }
}
