package terra.player.factions;

import terra.dashboard.GiantsDashboard;
import terra.player.FactionTypes;
import terra.player.Player;
//import terra.dashboard.GiantsDashbord;
import terra.resources.Resource;
import terra.unit.BuildingType;

public class Giants extends Player {

    private static Giants instance =  new Giants();

    private Giants() {
        this.setColor("RED");
        this.resource = new Resource(50, 50, 0);
        this.setSpadeCost(3);
        this.setShipLevel(0);
        this.dashboard = new GiantsDashboard();
        this.factionImage = "faction_images/giants.jpg";
    }

    public static Giants getInstance() {
        return instance;
    }
    @Override
    protected Resource getBuildingCost(BuildingType building, boolean isNeighbor) {
        switch(building) {
        case DWELLING:
            return new Resource(1,2,0);
        case TRADING_HOUSE:
            if(isNeighbor) {
                return new Resource(2,3,0);
            }
            return new Resource(2,6,0);
        case TEMPLE:
            return new Resource(2,5,0);
        case SANCTUARY:
            return new Resource(4,6,0);
        case STRONGHOLD:
            return new Resource(4,6,0);
        default:
            return null;
        }
    }
    @Override
    public FactionTypes getFaction() {
        return FactionTypes.GIANTS;
    }

}
