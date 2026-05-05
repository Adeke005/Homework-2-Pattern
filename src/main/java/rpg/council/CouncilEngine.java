package rpg.council;

import rpg.iterator.Quest;
import rpg.iterator.QuestIterator;
import rpg.iterator.QuestLog;
import rpg.iterator.QuestPriority;
import rpg.mediator.Captain;
import rpg.mediator.GuildHall;
import rpg.mediator.Healer;
import rpg.mediator.Quartermaster;
import rpg.mediator.Scout;

public class CouncilEngine {

    public void run() {
        QuestLog questLog = buildQuestLog();

        System.out.println("\n=== COUNCIL DEMO (Iterator + Mediator) ===");
        printOrderedQuests(questLog);
        printReversedQuests(questLog);
        printHighPriorityQuests(questLog);

        GuildHall guildHall = new GuildHall();
        Quartermaster quartermaster = new Quartermaster(guildHall);
        Scout scout = new Scout(guildHall);
        Healer healer = new Healer(guildHall);
        Captain captain = new Captain(guildHall);

        guildHall.subscribe("SUPPLY", quartermaster);
        guildHall.subscribe("RECON", scout);
        guildHall.subscribe("MEDICAL", healer);

        System.out.println("\nHigh-priority coordination:");
        QuestIterator highPriority = questLog.priorityIterator(QuestPriority.HIGH);
        while (highPriority.hasNext()) {
            Quest quest = highPriority.next();
            System.out.println("Captain coordinates " + quest.getTitle());
            captain.coordinateQuest(quest.getTitle());
        }
    }

    private QuestLog buildQuestLog() {
        QuestLog questLog = new QuestLog();
        questLog.addQuest(new Quest("Gather Herbs", QuestPriority.LOW));
        questLog.addQuest(new Quest("Escort Caravan", QuestPriority.MEDIUM));
        questLog.addQuest(new Quest("Defend Frontier", QuestPriority.HIGH));
        questLog.addQuest(new Quest("Clear Bandit Camp", QuestPriority.MEDIUM));
        questLog.addQuest(new Quest("Seal Abyss Gate", QuestPriority.HIGH));
        return questLog;
    }

    private void printOrderedQuests(QuestLog questLog) {
        System.out.println("\nOrdered quests:");
        printIterator(questLog.iterator());
    }

    private void printReversedQuests(QuestLog questLog) {
        System.out.println("\nReversed quests:");
        printIterator(questLog.reverseIterator());
    }

    private void printHighPriorityQuests(QuestLog questLog) {
        System.out.println("\nHIGH priority quests:");
        printIterator(questLog.priorityIterator(QuestPriority.HIGH));
    }

    private void printIterator(QuestIterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(" - " + iterator.next());
        }
    }
}
