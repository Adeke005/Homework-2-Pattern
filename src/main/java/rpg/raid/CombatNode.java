package rpg.raid;


public interface CombatNode {

    String getName();

    int getHealth();

    int dealDamage();

    void takeDamage(int damage);

    boolean isAlive();
}
