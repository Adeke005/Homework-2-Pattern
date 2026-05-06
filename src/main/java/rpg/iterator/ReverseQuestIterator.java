package rpg.iterator;

import java.util.NoSuchElementException;

public class ReverseQuestIterator implements QuestIterator {

    private final QuestLog questLog;
    private int index;

    public ReverseQuestIterator(QuestLog questLog) {
        this.questLog = questLog;
        this.index = questLog.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more quests in reverse traversal.");
        }
        return questLog.getAt(index--);
    }
}
