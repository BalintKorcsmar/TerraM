package terra.player;

import terra.board.Board;
import terra.resources.Resource;
import terra.unit.BuildingType;

public class RedPlayer extends Player {
    private static RedPlayer instance =  new RedPlayer();
    
    private RedPlayer() {
        this.setColor("RED");
        this.resource = new Resource(50, 50, 0);
        this.setSpadeCost(3);
        this.setShipLevel(0);
    }

    public static RedPlayer getInstance() {
        return instance;
    }

    private Resource getBuildingCost(BuildingType building) {
        switch(building) {
        case DWELLING:
            return new Resource(1,2,0);
        case SANCTUARY:
            return new Resource(4,6,0);
        case STRONGHOLD:
            return new Resource(4,6,0);
        case TEMPLE:
            return new Resource(2,5,0);
        case TRADING_HOUSE:
            return new Resource(2,6,0);
        default:
            return null;
        }
    }

    @Override
    public Resource getCost(int x, int y, BuildingType building) {
        int transformCost = Board.getInstance().getTile(x, y).GetDistance(x, y, this.getColor()) * this.getSpadeCost();
        Resource res = new Resource(transformCost + getBuildingCost(building).getWorker(),getBuildingCost(building).getGold(),0);
        return res;
    }
}
