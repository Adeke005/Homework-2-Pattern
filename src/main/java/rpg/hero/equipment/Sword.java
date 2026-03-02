package rpg.hero.equipment;

public class Sword implements Weapon {
    public String getName() {
        return "Medieval Sword";
    }

    @Override
    public int getAttackBonus() {
        return 2;
    }
}