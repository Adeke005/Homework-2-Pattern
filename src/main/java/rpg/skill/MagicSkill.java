package rpg.skill;

import rpg.effect.EffectImplementor;

public class MagicSkill extends Skill {

    public MagicSkill(EffectImplementor effect) {
        super(effect);
    }

    @Override
    public int use(int baseDamage) {
        System.out.println("Using Magic Skill");
        return effect.apply(baseDamage + 5);
    }
}
