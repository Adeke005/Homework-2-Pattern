package rpg.tower;

import java.util.ArrayList;
import java.util.List;
import rpg.floor.FloorResult;
import rpg.floor.TowerFloor;
import rpg.hero.character.Character;

public class TowerRunner {

    public TowerRunResult run(Character hero, List<TowerFloor> floors) {
        List<FloorResult> results = new ArrayList<>();

        for (TowerFloor floor : floors) {
            FloorResult floorResult = floor.explore(hero);
            results.add(floorResult);

            if (!hero.isAlive()) {
                System.out.println("Tower run stopped. " + hero.getName() + " has fallen.");
                break;
            }
        }

        return new TowerRunResult(results, hero.isAlive(), hero.getHealth());
    }
}
