package rpg.hero.equipment;

public class LeatherArmor implements Armor {
    public String getName() {
        return "Leather Armor";
    }

    @Override
    public int getDefenseBonus() {
        return 4;
    }
}
