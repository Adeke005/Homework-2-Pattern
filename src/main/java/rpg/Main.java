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

public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG SYSTEM DEMO ===\n");


        CharacterFactory warriorFactory = new WarriorFactory();
        Character hero = warriorFactory.createCharacter();

        hero.equip(new MedievalEquipmentFactory());

        System.out.println("Hero created:");
        hero.showStats();
        System.out.println();



        DragonBossBuilder builder =
                new DragonBossBuilder(new FireEnemyFactory());

        Enemy dragon = builder
                .setName("Fire Dragon")
                .setStats(new Stats(300, 40, 10, 5))
                .build();

        System.out.println("Enemy created:");
        System.out.println(dragon);
        System.out.println();



        Combatant heroAdapter = new HeroCombatantAdapter(hero);
        Combatant enemyAdapter = new EnemyCombatantAdapter(dragon);



        BattleEngine engine = BattleEngine.getInstance();
        engine.startBattle(heroAdapter, enemyAdapter);
    }
}
