package terra.player;

import terra.board.Board;
import terra.board.InvalidBuildException;
import terra.board.InvalidUpgradeException;
import terra.board.Tile;
import terra.board.TileNotEmptyException;
import terra.resources.*;
import terra.unit.BuildingFactory;
import terra.unit.BuildingType;

public abstract class Player implements Actions {
    private int SpadeLevel;
    protected Resource resource;
    protected String color;
    
    protected static BuildingFactory bFactory = new BuildingFactory();

    public Resource getResource() {
        return resource;
    }

    public void setResource(int worker, int gold, int priest) {
        this.resource.setWorker(worker);
        this.resource.setGold(gold);
        this.resource.setPriest(priest);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void print() {
        System.out.format("Hello! This is the %s player.\n", color);
        resource.print();
        
    }

    public int getSpadeLevel() {
        return SpadeLevel;
    }

    public void setSpadeLevel(int spadeLevel) {
        SpadeLevel = spadeLevel;
    }

    public abstract Resource getCost(int x, int y, BuildingType building );

    private void BuildStructure(int x, int y, BuildingType building) {
        Tile tile = Board.getInstance().getTile(x, y);

        if(this.resource.CanSpend(this.getCost(x, y, building))) {
            try {
                tile.setBuilding(bFactory.getBuilding(building, this.getColor()));
                this.resource.Spend(this.getCost(x, y, building));
                tile.TransformTile(this.getColor());
            } catch (TileNotEmptyException e) {
                System.out.format("Cannot build new Dwelling on a non empty tile! There is a %s %s building on the %d/%d tile.", e.getBuilding().getColor(),
                        e.getBuilding().getBuildingType().toString(),
                        tile.getX() + 1,
                        tile.getY() + 1);
            } catch (InvalidUpgradeException e) {
                System.out.format("Cannot upgrade a %s %s building to a %s %s one on the %d/%d tile.", e.getCurrent().getColor(),
                                                                                                       e.getCurrent().getBuildingType().toString(),
                                                                                                       e.getDesired().getColor(),
                                                                                                       e.getDesired().getBuildingType().toString(),
                                                                                                       tile.getX() + 1,
                                                                                                       tile.getY() + 1);
            } catch (InvalidBuildException e) {
                e.printStackTrace();
            } catch (InsufficientResourceException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                this.resource.Spend(this.getCost(x, y, BuildingType.DWELLING));
            } catch (InsufficientResourceException e) {
                System.out.println("Not enough resource to build structure! Need:");
                e.getNeeds().print();
            }
        }
    }
    
    /* Implementation of the Actions interface */
    public void TransformAndBuild(int x, int y) {
        BuildStructure(x, y, BuildingType.DWELLING);
    }

    public void UpgradeStructure(int x, int y, BuildingType building) {
        BuildStructure(x, y, building);
    }
}
