package terra.board;

import terra.unit.Building;

public class InvalidBuildException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Building desired;

    public InvalidBuildException(Building desired) {
        this.setDesired(desired);
    }

    public Building getDesired() {
        return desired;
    }

    public void setDesired(Building desired) {
        this.desired = desired;
    }


}
