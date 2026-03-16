package rpg.facade;

public class DungeonFacade {

    private PreparationSystem preparation = new PreparationSystem();
    private BattleSystem battle = new BattleSystem();
    private RewardSystem reward = new RewardSystem();

    public void runDungeon() {

        System.out.println("=== Dungeon Run Started ===");

        preparation.prepare();
        battle.startBattle();
        reward.giveReward();

        System.out.println("=== Dungeon Completed ===");

    }
}