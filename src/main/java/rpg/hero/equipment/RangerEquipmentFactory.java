package rpg.hero.equipment;

public class RangerEquipmentFactory implements EquipmentFactory {
    public Weapon createWeapon() {
        return new Bow();
    }

    public Armor createArmor() {
        return new LeatherArmor();
    }
}