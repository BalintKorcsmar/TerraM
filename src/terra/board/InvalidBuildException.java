package terra.board;

import terra.unit.Building;

public class InvalidBuildException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Building desired;
    private TileType type;

    public InvalidBuildException(Building desired, TileType type) {
        this.setDesired(desired);
        this.setType(type);
    }

    public Building getDesired() {
        return desired;
    }

    public void setDesired(Building desired) {
        this.desired = desired;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }


}
