package terra.board;

import terra.unit.BuildingType;

public class InvalidUpgradeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private BuildingType current;
    private BuildingType desired;

    public InvalidUpgradeException(BuildingType current, BuildingType desired) {
        this.setCurrent(current);
        this.setDesired(desired);
    }

    public BuildingType getCurrent() {
        return current;
    }

    public void setCurrent(BuildingType current) {
        this.current = current;
    }

    public BuildingType getDesired() {
        return desired;
    }

    public void setDesired(BuildingType desired) {
        this.desired = desired;
    }
}
