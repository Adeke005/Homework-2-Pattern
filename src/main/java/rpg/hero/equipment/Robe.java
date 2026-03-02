package rpg.hero.equipment;

public class Robe implements Armor {
    public String getName() {
        return "Magic Robe";
    }

    @Override
    public int getDefenseBonus() {
        return 5;
    }
}
