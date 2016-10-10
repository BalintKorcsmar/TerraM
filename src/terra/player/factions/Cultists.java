/**
 * 
 */
package terra.player.factions;

import terra.dashboard.CultistsDashboard;
import terra.player.FactionTypes;
import terra.player.Player;
import terra.resources.Resource;
import terra.unit.BuildingType;

/**
 * @author B�lint
 *
 */
public class Cultists extends Player {
    private static Cultists instance =  new Cultists();

    private Cultists() {
        this.setColor("BROWN");
        this.resource = new Resource(50, 50, 0);
        this.setSpadeCost(3);
        this.setShipLevel(0);
        this.dashboard = new CultistsDashboard();
    }
    /* (non-Javadoc)
     * @see terra.player.Player#getCost(int, int, terra.unit.BuildingType)
     */
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
            return new Resource(4,8,0);
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
        return FactionTypes.CULTISTS;
    }

}
