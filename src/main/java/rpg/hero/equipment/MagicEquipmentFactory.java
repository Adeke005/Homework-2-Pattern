package rpg.hero.equipment;

public class MagicEquipmentFactory implements EquipmentFactory {
    public Weapon createWeapon() {
        return new Staff();
    }

    public Armor createArmor() {
        return new Robe();
    }
}
