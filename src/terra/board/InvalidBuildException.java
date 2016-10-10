package terra.board;

import terra.unit.BuildingType;

public class InvalidBuildException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private BuildingType desired;
    private TileType type;

    public InvalidBuildException(BuildingType desired, TileType type) {
        this.setDesired(desired);
        this.setType(type);
    }

    public BuildingType getDesired() {
        return desired;
    }

    public void setDesired(BuildingType desired) {
        this.desired = desired;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }


}
