package rpg.hero.equipment;

public class PlateArmor implements Armor {

    @Override
    public String getName() {
        return "Plate Armor";
    }

    @Override
    public int getDefenseBonus() {
        return 5; // пример значения
    }
}