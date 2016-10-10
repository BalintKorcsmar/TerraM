package terra.unit;

public class Temple extends Building {

    public Temple(String color) {
        this.color = color;
    }

    @Override
    public void build() {
        // TODO Auto-generated method stub
        System.out.println("This is a temple!");
    }

    @Override
    public BuildingType getBuildingType() {
        return BuildingType.TEMPLE;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Temple";
    }

}
