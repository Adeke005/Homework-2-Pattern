package rpg.enemy;

public interface Enemy extends Cloneable {
    String getName();
    int getHealth();
    int getAttack();
    int getDefense();
    int getSpeed();

    void takeDamage(int rawDamage);
    void performAIAction();

    Enemy clone();
}

