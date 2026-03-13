package rpg.skill;

import rpg.effect.EffectImplementor;

public abstract class Skill {

    protected EffectImplementor effect;

    public Skill(EffectImplementor effect) {
        this.effect = effect;
    }

    public abstract int use(int baseDamage);
}