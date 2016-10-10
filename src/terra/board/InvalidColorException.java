package terra.board;

import terra.unit.BuildingType;

public class InvalidColorException extends InvalidUpgradeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String currentColor;
    private String desiredColor;

    InvalidColorException(BuildingType current, BuildingType desired, 
                          String currentColor, String desiredColor) {

        super(current, desired);
        this.setCurrentColor(currentColor);
        this.desiredColor = desiredColor;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public String getDesiredColor() {
        return desiredColor;
    }

    public void setDesiredColor(String desiredColor) {
        this.desiredColor = desiredColor;
    }
}
