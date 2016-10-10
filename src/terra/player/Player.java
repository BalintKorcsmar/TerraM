package terra.player;

import terra.board.*;
import terra.dashboard.Dashboard;
import terra.dashboard.NoMoreBuildingException;
import terra.resources.*;
import terra.unit.BuildingType;

public abstract class Player implements Actions {
    private int SpadeCost;
    private int shipLevel;
    protected Resource resource;
    protected String color;
    protected Dashboard dashboard;

    private final Resource SpadeUpgradeCost = new Resource(2, 5, 1);
    private final Resource ShipUpgradeCost = new Resource(0, 4, 1);

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

    public Dashboard getDashboard() {
        return this.dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public void print() {
        System.out.format("Hello! This is the %s player.\n", color);
        resource.print();
        
    }

    public int getSpadeCost() {
        return SpadeCost;
    }

    public void setSpadeCost(int SpadeCost) {
        this.SpadeCost = SpadeCost;
    }

    public void decrementSpadeCost() throws SpadeUpgradeException {
        if(this.getSpadeCost() == 1) {
            throw new SpadeUpgradeException(1);
        }
        else {
            this.SpadeCost -= 1;
        }
    }

    public int getShipLevel() {
        return shipLevel;
    }

    public void setShipLevel(int shipLevel) {
        this.shipLevel = shipLevel;
    }

    public void incrementShipLevel() throws ShipUpgradeException {
        if(this.getShipLevel() == 3) {
            throw new ShipUpgradeException(3);
        } else {
            this.shipLevel += 1;
        }
    }

    protected abstract Resource getBuildingCost(BuildingType building, boolean isNeighbor );

    public Resource getCost(int x, int y, BuildingType building, boolean isNeighbor) {
        int transformCost = Board.getInstance().getTile(x, y).getSteps(x, y, this.getColor()) * this.getSpadeCost();
        Resource res = new Resource(transformCost + getBuildingCost(building, isNeighbor).getWorker(),getBuildingCost(building, isNeighbor).getGold(),0);
        return res;
    }

    private boolean BuildStructure(int x, int y, BuildingType building) {
        Tile tile = Board.getInstance().getTile(x, y);
        boolean isNeighborTile = tile.isNeighbor();
        boolean result = false;

        if(this.resource.CanSpend(this.getCost(x, y, building, isNeighborTile))) {
            try {
                result = tile.setBuilding(building, this.getColor());
                this.resource.Spend(this.getCost(x, y, building, isNeighborTile));
                tile.TransformTile(this.getColor());
            } catch (TileNotEmptyException e) {
                System.out.format("Cannot build new Dwelling on a non empty tile! There is a %s %s building on the %d/%d tile.\n", e.getBuilding().getColor(),
                        e.getBuilding().getBuildingType().toString(),
                        tile.getRow() + 1,
                        tile.getColumn() + 1);
            } catch (InvalidUpgradeException e) {
                if (e instanceof InvalidColorException) {
                    System.out.format("Cannot upgrade a %s %s building to a %s %s on the %d/%d tile.\n",((InvalidColorException) e).getCurrentColor(), e.getCurrent().toString(),
                                                                                                        ((InvalidColorException) e).getDesiredColor(),
                                                                                                        e.getDesired().toString(),
                                                                                                        tile.getRow() + 1,
                                                                                                        tile.getColumn() + 1);

                }
                System.out.format("Cannot upgrade a %s building to a %s on the %d/%d tile.\n",e.getCurrent().toString(),
                                                                                                       e.getDesired().toString(),
                                                                                                       tile.getRow() + 1,
                                                                                                       tile.getColumn() + 1);
            } catch (InvalidBuildException e) {
               if(e.getType() == TileType.RIVER) {
                   System.out.println("Cannot build any building on a river tile!");
               }
               else {
                   System.out.format("Cannot build a %s building on an empty tile!", e.getDesired().toString());
               }
            } catch (InsufficientResourceException e) {
                e.printStackTrace();
            } catch (NoMoreBuildingException e) {
                System.out.format("No more %s building on the dashboard!", e.getBuilding().toString());
            }
        }
        else {
            try {
                this.resource.Spend(this.getCost(x, y, BuildingType.DWELLING, isNeighborTile));
            } catch (InsufficientResourceException e) {
                System.out.println("Not enough resource to build structure! Need:\n");
                e.getNeeds().print();
            }
        }
        return result;
    }
    
    /* Implementation of the Actions interface */
    public void TransformAndBuild(int x, int y) {
        boolean result;
        result = BuildStructure(x, y, BuildingType.DWELLING);
        if(result) {
            PlayerAccess.getInstance().incrementCurrentPlayer();
        }
    }

    public void UpgradeStructure(int x, int y, BuildingType building) {
        BuildStructure(x, y, building);
    }

    public void UpgradeSpades() {
        try {
            if(this.getSpadeCost() == 1) {
                this.decrementSpadeCost();
            }
            this.resource.Spend(SpadeUpgradeCost);
            this.decrementSpadeCost();
        } catch (InsufficientResourceException e) {
            System.out.println("Not enough resource to upgrade your spades! Need:");
            e.getNeeds().print();
        } catch (SpadeUpgradeException e) {
            System.out.println("Cannot upgrade spade further than level 3.");
        }
    }

    public void AdvanceOnShippingTrack() {
        try {
            if(this.getShipLevel() == 3) {
                this.incrementShipLevel();
            }
            this.resource.Spend(ShipUpgradeCost);
            this.incrementShipLevel();
        } catch (InsufficientResourceException e) {
            System.out.println("Not enough resource to upgrade your spades! Need:");
            e.getNeeds().print();
        } catch (ShipUpgradeException e) {
            System.out.println("Cannot upgrade spade further than level 3.");
        }
    }

    public abstract FactionTypes getFaction();

}

