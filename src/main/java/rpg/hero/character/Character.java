package rpg.hero.character;

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

    public void showStats() {
        System.out.println(name + " | HP: " + health + " | ATK: " + attack);
        System.out.println("Weapon: " + weapon.getName());
        System.out.println("Armor: " + armor.getName());
    }
}