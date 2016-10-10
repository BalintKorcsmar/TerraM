package terra.dashboard;

import terra.unit.BuildingType;

public class NoMoreBuildingException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private BuildingType building;

    NoMoreBuildingException(BuildingType building) {
        this.setBuilding(building);
    }

    public BuildingType getBuilding() {
        return building;
    }

    public void setBuilding(BuildingType building) {
        this.building = building;
    }
}
