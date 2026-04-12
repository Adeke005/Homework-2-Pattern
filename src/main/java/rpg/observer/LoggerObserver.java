package rpg.observer;


public class LoggerObserver implements GameObserver {

    @Override
    public void onEvent(GameEvent event) {
        System.out.println(
                "[EVENT] " + event.getType() +
                        " | Source: " + event.getSourceName() +
                        " | Value: " + event.getValue()
        );
    }
}