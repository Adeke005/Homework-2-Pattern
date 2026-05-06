package rpg.iterator;

public class Quest {

    private final String title;
    private final QuestPriority priority;

    public Quest(String title, QuestPriority priority) {
        this.title = title;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public QuestPriority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Quest{title='" + title + "', priority=" + priority + "}";
    }
}
