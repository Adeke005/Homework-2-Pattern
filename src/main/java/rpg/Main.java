package rpg;

import rpg.enemy.core.Stats;
import rpg.hero.character.Character;
import rpg.hero.character.WarriorFactory;
import rpg.hero.character.CharacterFactory;
import rpg.hero.equipment.MedievalEquipmentFactory;

import rpg.enemy.builder.DragonBossBuilder;
import rpg.enemy.factory.FireEnemyFactory;
import rpg.enemy.core.Enemy;

import rpg.adapter.Combatant;
import rpg.adapter.HeroCombatantAdapter;
import rpg.adapter.EnemyCombatantAdapter;

import rpg.battle.BattleEngine;

import rpg.effect.*;
import rpg.skill.*;
import rpg.raid.*;
import rpg.decorator.*;
import rpg.facade.*;

import rpg.observer.*;
public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG SYSTEM DEMO ===\n");

        // ================= HERO =================
        CharacterFactory warriorFactory = new WarriorFactory();
        Character hero = warriorFactory.createCharacter();
        hero.equip(new MedievalEquipmentFactory());

        hero.showStats();
        System.out.println();

        // ================= ENEMY (BOSS) =================
        DragonBossBuilder builder =
                new DragonBossBuilder(new FireEnemyFactory());

        Enemy dragon = builder
                .setName("Fire Dragon")
                .setStats(new Stats(300, 40, 10, 5))
                .build();

        System.out.println(dragon);
        System.out.println();

        // ================= OBSERVER =================
        EventManager eventManager = new EventManager();

        eventManager.subscribe(new LoggerObserver());
        eventManager.subscribe(new AchievementObserver());
        eventManager.subscribe(new SupportObserver());

        // ================= ADAPTER =================
        Combatant heroAdapter = new HeroCombatantAdapter(hero);

        EnemyCombatantAdapter enemyAdapter = new EnemyCombatantAdapter(dragon);
        enemyAdapter.setEventManager(eventManager); // 🔥 связь с Observer

        // ================= BATTLE =================
        System.out.println("=== BATTLE ENGINE (HW7) ===");

        BattleEngine engine = BattleEngine.getInstance();
        engine.setEventManager(eventManager);

        engine.startBattle(heroAdapter, enemyAdapter);

        // ================= SKILLS (Bridge) =================
        System.out.println("\n=== SKILL DEMO (Bridge Pattern) ===");

        Skill fireSlash = new SlashSkill(new FireEffect());
        Skill iceMagic = new MagicSkill(new IceEffect());
        Skill poisonSlash = new SlashSkill(new PoisonEffect());

        int baseDamage = hero.attack();

        System.out.println("Fire Slash damage: " + fireSlash.use(baseDamage));
        System.out.println("Ice Magic damage: " + iceMagic.use(baseDamage));
        System.out.println("Poison Slash damage: " + poisonSlash.use(baseDamage));

        // ================= RAID (Composite) =================
        System.out.println("\n=== RAID DEMO (Composite Pattern) ===");

        HeroUnit heroUnit = new HeroUnit(heroAdapter);
        EnemyUnit dragonUnit = new EnemyUnit(enemyAdapter);

        RaidGroup heroParty = new RaidGroup("Hero Party");
        heroParty.add(heroUnit);

        RaidGroup dragonRaid = new RaidGroup("Dragon Raid");
        dragonRaid.add(dragonUnit);

        RaidEngine raidEngine = new RaidEngine();
        raidEngine.startRaid(heroParty, dragonRaid);

        // ================= DECORATOR =================
        System.out.println("\n=== DECORATOR DEMO ===");

        Attack attack = new BasicAttack(10);

        attack = new FireRuneDecorator(attack);
        attack = new CriticalAttackDecorator(attack);
        attack = new PoisonAttackDecorator(attack);

        System.out.println("Total damage: " + attack.dealDamage());

        // ================= FACADE =================
        System.out.println("\n=== FACADE DEMO ===");

        DungeonFacade dungeon = new DungeonFacade();

        dungeon.runDungeon();
        dungeon.printSummary();
    }
}