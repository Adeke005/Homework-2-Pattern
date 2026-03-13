package rpg.effect;

public class IceEffect implements EffectImplementor {

    @Override
    public int applyEffect(int baseDamage) {
        System.out.println("Ice effect applied!");
        return baseDamage + 3;
    }
}