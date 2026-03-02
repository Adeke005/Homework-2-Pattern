package rpg.hero.character;

import rpg.hero.equipment.Armor;
import rpg.hero.equipment.EquipmentFactory;
import rpg.hero.equipment.Weapon;

public abstract class Character {

    protected String name;
    protected int health;
    protected int attack;

    protected Weapon weapon;
    protected Armor armor;


    public void equip(EquipmentFactory factory) {
        this.weapon = factory.createWeapon();
        this.armor = factory.createArmor();
    }



    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        int weaponBonus = (weapon != null) ? weapon.getAttackBonus() : 0;
        return attack + weaponBonus;
    }


    public void receiveDamage(int damage) {

        int defense = (armor != null) ? armor.getDefenseBonus() : 0;

        int finalDamage = Math.max(0, damage - defense);

        health -= finalDamage;

        if (health < 0) {
            health = 0;
        }
    }

    public void showStats() {

        System.out.println("===== CHARACTER =====");
        System.out.println("Name: " + name);
        System.out.println("HP: " + health);
        System.out.println("Base ATK: " + attack);

        if (weapon != null) {
            System.out.println("Weapon: " + weapon.getName()
                    + " (+" + weapon.getAttackBonus() + " ATK)");
        }

        if (armor != null) {
            System.out.println("Armor: " + armor.getName()
                    + " (+" + armor.getDefenseBonus() + " DEF)");
        }

        System.out.println("=====================");
    }
}