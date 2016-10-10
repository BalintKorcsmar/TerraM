package terra.player.factions;

import terra.dashboard.AlchemistDashboard;
import terra.player.FactionTypes;
import terra.player.Player;
import terra.resources.Resource;
import terra.unit.BuildingType;

public class Aclhemists extends Player {
    private static Aclhemists instance =  new Aclhemists();

    private Aclhemists() {
        this.setColor("BLACK");
        this.resource = new Resource(50, 50, 0);
        this.setSpadeCost(3);
        this.setShipLevel(0);
        this.dashboard = new AlchemistDashboard();
        this.factionImage = "faction_images/alchemists.jpg";
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

    public static Player getInstance() {
        // TODO Auto-generated method stub
        return instance;
    }

    @Override
    public FactionTypes getFaction() {
        return FactionTypes.ALCHEMISTS;
    }
}
