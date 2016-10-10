package terra.unit;

public class TradingHouse extends Building {

	@Override
	public void build() {
		// TODO Auto-generated method stub
		System.out.println("This is a trading house!");
	}

    @Override
    public BuildingType getBuildingType() {
        return BuildingType.TRADING_HOUSE;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Trading House";
    }

}
