package rpg.skill;

import rpg.effect.EffectImplementor;

public class SlashSkill extends Skill {

    public SlashSkill(EffectImplementor effect) {
        super(effect);
    }

    @Override
    public int use(int baseDamage) {
        System.out.println("Using Slash Skill");
        return effect.applyEffect(baseDamage);
    }
}