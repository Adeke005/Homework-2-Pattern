package rpg.iterator;

import java.util.NoSuchElementException;

public class PriorityQuestIterator implements QuestIterator {

    private final QuestLog questLog;
    private final QuestPriority targetPriority;
    private int index;

    public PriorityQuestIterator(QuestLog questLog, QuestPriority targetPriority) {
        this.questLog = questLog;
        this.targetPriority = targetPriority;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        advanceToNextMatch();
        return index < questLog.size();
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            throw new NoSuchElementException(
                    "No more quests with priority: " + targetPriority
            );
        }
        return questLog.getAt(index++);
    }

    private void advanceToNextMatch() {
        while (index < questLog.size()) {
            Quest quest = questLog.getAt(index);
            if (quest.getPriority() == targetPriority) {
                break;
            }
            index++;
        }
    }
}
