package rpg.iterator;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {

    private final List<Quest> quests = new ArrayList<>();

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public QuestIterator iterator() {
        return new OrderedQuestIterator(this);
    }

    public QuestIterator reverseIterator() {
        return new ReverseQuestIterator(this);
    }

    public QuestIterator priorityIterator(QuestPriority priority) {
        return new PriorityQuestIterator(this, priority);
    }

    int size() {
        return quests.size();
    }

    Quest getAt(int index) {
        return quests.get(index);
    }
}
