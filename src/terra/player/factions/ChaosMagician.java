package terra.player.factions;

import terra.dashboard.ChaosMagicianDashbord;
import terra.player.FactionTypes;
import terra.player.Player;
import terra.resources.Resource;
import terra.unit.BuildingType;

public class ChaosMagician extends Player {
    private static ChaosMagician instance =  new ChaosMagician();

    private ChaosMagician() {
        this.setColor("RED");
        this.resource = new Resource(50, 50, 0);
        this.setSpadeCost(3);
        this.setShipLevel(0);
        this.dashboard = new ChaosMagicianDashbord();
        this.factionImage = "faction_images/chaos_magicians.jpg";
    }

    public static ChaosMagician getInstance() {
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
            return new Resource(4,8,0);
        case STRONGHOLD:
            return new Resource(4,4,0);
        default:
            return null;
        }
    }

    @Override
    public FactionTypes getFaction() {
        return FactionTypes.CHAOS_MAGICIANS;
    }

}
