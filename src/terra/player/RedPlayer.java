package terra.player;

import terra.resources.InsufficientResourceException;
import terra.resources.Resource;
import terra.unit.BuildingType;

public class RedPlayer extends Player {
    private final Resource DwellingCost = new Resource(1,2,0);
    
    private static RedPlayer instance =  new RedPlayer();
    
    private RedPlayer() {
        this.setColor("Red");
        this.resource = new Resource(3, 15, 0);
    }
    
    public static RedPlayer getInstance() {
        return instance;
    }
    
    public void build(BuildingType building) {
        bFactory.getBuilding(building, color);
        
        try {
        	this.resource.Spend(DwellingCost);
        } catch (InsufficientResourceException e){
        	System.out.println("You do not have enough resources. You would need:");
        	e.getNeeds().print();
        }
    }

    @Override
    public Resource getCost(int x, int y, BuildingType building) {
        Resource res = new Resource(1,2,0);
        return res;
    }

}
