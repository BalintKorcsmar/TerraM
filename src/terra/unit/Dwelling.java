package terra.unit;

public class Dwelling extends Building {

	public Dwelling(String color) {
		this.color = color;
	}
	@Override
	public void build() {
		// TODO Auto-generated method stub
		System.out.format("This is a %s dwelling!\n", getColor());
	}
    @Override
    public BuildingType getBuildingType() {
        return BuildingType.DWELLING;
    }
    @Override
    public String toString() {
        return "Dwelling";
    }

}
