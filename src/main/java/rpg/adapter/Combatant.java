package rpg.adapter;

public interface Combatant {

    String getName();

    int getHealth();

    void takeDamage(int damage);

    int dealDamage();

    boolean isAlive();
}