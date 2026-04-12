package rpg.observer;


public class AchievementObserver implements GameObserver {

    @Override
    public void onEvent(GameEvent event) {

        switch (event.getType()) {

            case BOSS_DEFEATED ->
                    System.out.println("🏆 Achievement: Boss Slayer");

            case HERO_DIED ->
                    System.out.println("💀 Achievement: First Death");

            case BOSS_PHASE_CHANGED ->
                    System.out.println("⚔ Boss entered phase " + event.getValue());

            default -> {
            }
        }
    }
}