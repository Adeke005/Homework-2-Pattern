package rpg.enemy.prototype;

import rpg.enemy.core.Enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {

    private final Map<String, Enemy> prototypes = new HashMap<>();

    public void register(String key, Enemy enemy) {
        prototypes.put(key, enemy);
    }

    public Enemy create(String key) {

        Enemy prototype = prototypes.get(key);

        if (prototype == null) {
            throw new IllegalArgumentException("No enemy registered with key: " + key);
        }

        return prototype.clone();
    }

    public boolean contains(String key) {
        return prototypes.containsKey(key);
    }
}
