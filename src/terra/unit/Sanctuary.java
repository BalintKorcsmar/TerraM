package terra.unit;

public class Sanctuary extends Building {

    public Sanctuary(String color) {
        this.color = color;
    }
    @Override
    public void build() {
        // TODO Auto-generated method stub
        System.out.println("This is a sanctuary!");
    }

    @Override
    public BuildingType getBuildingType() {
        return BuildingType.SANCTUARY;
    }

    @Override
    public String toString() {
        return "Sanctuary";
    }

}
