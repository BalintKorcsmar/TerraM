package terra.dashboard;

import terra.unit.Building;
import terra.unit.BuildingFactory;
import terra.unit.BuildingType;

public abstract class Dashboard {

    protected int dwellings;
    protected int tradingHouses;
    protected int temples;
    protected int sanctuary;
    protected int stronghold;

    public Dashboard() {
        this.dwellings = 8;
        this.tradingHouses = 4;
        this.temples = 3;
        this.sanctuary = 1;
        this.stronghold = 1;
    }

    protected static BuildingFactory bFactory = new BuildingFactory();
 
    public Building getBuilding(BuildingType building, String color) throws NoMoreBuildingException {
         switch(building) {
        case DWELLING:
            if(this.dwellings > 0) {
                this.dwellings -= 1;
                return bFactory.getBuilding(building, color);
            }
            else throw new NoMoreBuildingException(building);
        case TRADING_HOUSE:
            if(this.tradingHouses > 0) {
                this.tradingHouses -= 1;
                this.dwellings += 1;
                return bFactory.getBuilding(building, color);
            }
            else throw new NoMoreBuildingException(building);
        case STRONGHOLD:
            if(this.stronghold > 0) {
                this.stronghold -= 1;
                this.tradingHouses += 1;
                return bFactory.getBuilding(building, color);
            }
            else throw new NoMoreBuildingException(building);
        case TEMPLE:
            if(this.temples > 0) {
                this.temples -= 1;
                this.tradingHouses += 1;
                return bFactory.getBuilding(building, color);
            }
            else throw new NoMoreBuildingException(building);
        case SANCTUARY:
            if(this.sanctuary > 0) {
                this.sanctuary -= 1;
                this.temples += 1;
                return bFactory.getBuilding(building, color);
            }
            else throw new NoMoreBuildingException(building);
        default:
            return null;
         
         }
    }

    public void print() {
        System.out.format("The number of dwellings: %d trading houses: %d, temples: %d, sanctury: %d, stronghold: %d", this.dwellings,
                                                                                                                       this.tradingHouses,
                                                                                                                       this.temples ,
                                                                                                                       this.sanctuary,
                                                                                                                       this.stronghold);
    }
}
