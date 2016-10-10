package terra.unit;

public class Stronghold extends Building {

	@Override
	public void build() {
		// TODO Auto-generated method stub
		System.out.println("This is a stronghold!");
	}

    @Override
    public BuildingType getBuildingType() {
        return BuildingType.STRONGHOLD;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Stronghold";
    }

}
