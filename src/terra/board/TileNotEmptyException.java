package terra.board;

import terra.unit.Building;

public class TileNotEmptyException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Building building;
    
    public TileNotEmptyException(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }
}
