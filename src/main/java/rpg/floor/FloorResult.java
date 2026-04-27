package rpg.floor;

public class FloorResult {

    private final String floorName;
    private final boolean success;
    private final String details;
    private final int heroHpAfterFloor;

    public FloorResult(String floorName, boolean success, String details, int heroHpAfterFloor) {
        this.floorName = floorName;
        this.success = success;
        this.details = details;
        this.heroHpAfterFloor = heroHpAfterFloor;
    }

    public String getFloorName() {
        return floorName;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDetails() {
        return details;
    }

    public int getHeroHpAfterFloor() {
        return heroHpAfterFloor;
    }

    @Override
    public String toString() {
        String status = success ? "SUCCESS" : "FAILED";
        return floorName + " -> " + status + " | " + details + " | HP: " + heroHpAfterFloor;
    }
}
