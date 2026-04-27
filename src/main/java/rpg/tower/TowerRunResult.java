package rpg.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rpg.floor.FloorResult;

public class TowerRunResult {

    private final List<FloorResult> floorResults;
    private final boolean heroSurvived;
    private final int heroRemainingHp;

    public TowerRunResult(List<FloorResult> floorResults, boolean heroSurvived, int heroRemainingHp) {
        this.floorResults = Collections.unmodifiableList(new ArrayList<>(floorResults));
        this.heroSurvived = heroSurvived;
        this.heroRemainingHp = heroRemainingHp;
    }

    public List<FloorResult> getFloorResults() {
        return floorResults;
    }

    public boolean isHeroSurvived() {
        return heroSurvived;
    }

    public int getHeroRemainingHp() {
        return heroRemainingHp;
    }
}
