package terra.unit;

public class BuildingFactory {

    public Building getBuilding(BuildingType building, String color) {
        switch (building) {
            case DWELLING:
                return new Dwelling(color);
            case TRADING_HOUSE:
                return new TradingHouse();
            case TEMPLE:
                return new Temple();
            case SANCTUARY:
                return new Sanctuary();
            case STRONGHOLD:
                return new Stronghold();
            default:
                return null;
        }
    }
}