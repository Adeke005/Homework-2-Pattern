package rpg.observer;


public class SupportObserver implements GameObserver {

    @Override
    public void onEvent(GameEvent event) {

        if (event.getType() == GameEventType.HERO_LOW_HP) {
            System.out.println(
                    "Support heals " + event.getSourceName() +
                            " (HP=" + event.getValue() + ")"
            );
        }
    }
}