package terra.board;

import terra.unit.Building;

public class InvalidUpgradeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Building current;
    private Building desired;

    public InvalidUpgradeException(Building current, Building desired) {
        this.setCurrent(current);
        this.setDesired(desired);
    }

    public Building getCurrent() {
        return current;
    }

    public void setCurrent(Building current) {
        this.current = current;
    }

    public Building getDesired() {
        return desired;
    }

    public void setDesired(Building desired) {
        this.desired = desired;
    }
}
