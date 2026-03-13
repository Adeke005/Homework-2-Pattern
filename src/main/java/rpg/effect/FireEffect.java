package rpg.effect;

public class FireEffect implements EffectImplementor {

    @Override
    public int applyEffect(int baseDamage) {
        System.out.println("Fire effect applied!");
        return baseDamage + 5;
    }
}