package rpg.hero.equipment;

public class MedievalEquipmentFactory implements EquipmentFactory {
    public Weapon createWeapon() {
        return new Sword();
    }

    public Armor createArmor() {
        return new PlateArmor();
    }
}
