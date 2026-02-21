package rpg.enemy.enemy;

public class GoblinKing extends Goblin {

    private boolean summonsMinions;

    public void setSummonsMinions(boolean value) {
        this.summonsMinions = value;
    }

    public void summonMinions() {
        if (summonsMinions) {
            System.out.println(name + " summons goblin minions!");
        }
    }

    @Override
    public GoblinKing clone() {
        GoblinKing clone = (GoblinKing) super.clone();
        clone.summonsMinions = this.summonsMinions;
        return clone;
    }
}
