package terra.player.factions;

import terra.dashboard.EngineersDashboard;
import terra.player.FactionTypes;
import terra.player.Player;
import terra.resources.Resource;
import terra.unit.BuildingType;

public class Engineers extends Player {
    private static Engineers instance =  new Engineers();

    private Engineers() {
        this.setColor("GREY");
        this.resource = new Resource(50, 50, 0);
        this.setSpadeCost(3);
        this.setShipLevel(0);
        this.dashboard = new EngineersDashboard();
    }

    @Override
    protected Resource getBuildingCost(BuildingType building, boolean isNeighbor) {
        switch(building) {
        case DWELLING:
            return new Resource(1,1,0);
        case TRADING_HOUSE:
            if(isNeighbor) {
                return new Resource(1,2,0);
            }
            return new Resource(1,4,0);
        case TEMPLE:
            return new Resource(1,4,0);
        case SANCTUARY:
            return new Resource(3,6,0);
        case STRONGHOLD:
            return new Resource(3,6,0);
        default:
            return null;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static Player getInstance() {
        // TODO Auto-generated method stub
        return instance;
    }

    @Override
    public FactionTypes getFaction() {
        return FactionTypes.ENGINEERS;
    }

}
