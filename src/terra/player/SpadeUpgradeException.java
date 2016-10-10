package terra.player;

public class SpadeUpgradeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int spadeLevel;

    public SpadeUpgradeException(int level) {
        this.setSpadeLevel(level);
    }

    public int getSpadeLevel() {
        return spadeLevel;
    }

    private void setSpadeLevel(int spadeLevel) {
        this.spadeLevel = spadeLevel;
    }
}
