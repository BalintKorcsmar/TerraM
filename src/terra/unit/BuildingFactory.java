package terra.unit;

public class BuildingFactory {

    public Building getBuilding(BuildingType building, String color) {
        switch (building) {
            case DWELLING:
                return new Dwelling(color);
            case TRADING_HOUSE:
                return new TradingHouse(color);
            case TEMPLE:
                return new Temple(color);
            case SANCTUARY:
                return new Sanctuary(color);
            case STRONGHOLD:
                return new Stronghold(color);
            default:
                return null;
        }
    }
}