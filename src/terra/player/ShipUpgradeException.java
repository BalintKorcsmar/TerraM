package terra.player;

public class ShipUpgradeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private int shipLevel;

    public ShipUpgradeException(int level) {
        this.setShipLevel(level);
    }

    public int getShipLevel() {
        return shipLevel;
    }

    private void setShipLevel(int shipLevel) {
        this.shipLevel = shipLevel;
    }


}
