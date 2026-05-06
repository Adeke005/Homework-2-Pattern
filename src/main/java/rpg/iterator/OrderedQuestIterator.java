package rpg.iterator;

import java.util.NoSuchElementException;

public class OrderedQuestIterator implements QuestIterator {

    private final QuestLog questLog;
    private int index;

    public OrderedQuestIterator(QuestLog questLog) {
        this.questLog = questLog;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < questLog.size();
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more quests in ordered traversal.");
        }
        return questLog.getAt(index++);
    }
}
