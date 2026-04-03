package rpg.effect;

public class PoisonEffect implements EffectImplementor {

    @Override
    public int apply(int baseDamage) {
        System.out.println("Poison effect applied!");
        return baseDamage + 4;
    }
}