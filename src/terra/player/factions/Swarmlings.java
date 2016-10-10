package terra.player.factions;

import terra.dashboard.SwarmlingsDashboard;
import terra.player.FactionTypes;
import terra.player.Player;
import terra.resources.Resource;
import terra.unit.BuildingType;

public class Swarmlings extends Player {
    private static Swarmlings instance =  new Swarmlings();

    private Swarmlings() {
        this.setColor("BLUE");
        this.resource = new Resource(50, 50, 0);
        this.setSpadeCost(3);
        this.setShipLevel(0);
        this.dashboard = new SwarmlingsDashboard();
        this.factionImage = "faction_images/swarmlings.jpg";
    }

    @Override
    protected Resource getBuildingCost(BuildingType building, boolean isNeighbor) {
        switch(building) {
        case DWELLING:
            return new Resource(2,3,0);
        case TRADING_HOUSE:
            if(isNeighbor) {
                return new Resource(3,4,0);
            }
            return new Resource(3,8,0);
        case TEMPLE:
            return new Resource(3,6,0);
        case SANCTUARY:
            return new Resource(5,8,0);
        case STRONGHOLD:
            return new Resource(5,8,0);
        default:
            return null;
        }
    }
    public static Player getInstance() {
        // TODO Auto-generated method stub
        return instance;
    }

    @Override
    public FactionTypes getFaction() {
        return FactionTypes.SWARMLINGS;
    }

}
