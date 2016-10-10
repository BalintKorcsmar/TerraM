package terra.board;

import terra.unit.Building;
import terra.unit.BuildingType;

public class Tile {
    private int x, y;
    private Building building;
    private TileType type;

    public Tile(int x, int y, TileType type) {
        this.setX(x);
        this.setY(y);
        building = null;
        this.setType(type);
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) throws TileNotEmptyException,
                                                      InvalidUpgradeException,
                                                      InvalidBuildException {
        if(this.getType() == TileType.RIVER) {
            throw new InvalidBuildException(building, this.getType());
        }
        if(!this.isEmpty()) {
            if(building.getBuildingType() == BuildingType.DWELLING) {
                throw new TileNotEmptyException(this.getBuilding());
            }
            
            switch(this.getBuilding().getBuildingType()) {
                case DWELLING:
                    if(building.getBuildingType() == BuildingType.TRADING_HOUSE) {
                        this.building = building;
                    } 
                    else {
                        throw new InvalidUpgradeException(this.getBuilding(), building);
                    }
                    break;
                case SANCTUARY:
                    throw new InvalidUpgradeException(this.getBuilding(), building);
                case STRONGHOLD:
                    throw new InvalidUpgradeException(this.getBuilding(), building);
                case TEMPLE:
                    if(building.getBuildingType() == BuildingType.SANCTUARY) {
                        this.building = building;
                    } 
                    else {
                        throw new InvalidUpgradeException(this.getBuilding(), building);
                    }
                    break;
                case TRADING_HOUSE:
                    if(building.getBuildingType() == BuildingType.STRONGHOLD ||
                       building.getBuildingType() == BuildingType.TEMPLE) {
                        this.building = building;
                    }
                    else {
                        throw new InvalidUpgradeException(this.getBuilding(), building);
                    }
                    break;
                default:
                    break;
                
            }
        }
        else {
            if(building.getBuildingType() == BuildingType.DWELLING) {
                this.building = building;
            }
            else {
                throw new InvalidBuildException(building, this.getType());
            }
        }
    }

    public boolean isEmpty() {
        if(getBuilding() == null) {
            return true;
        }
        else return false;
    }

    public TileType getType() {
        return this.type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public int GetDistance(int x, int y, String color) {
        Board board = Board.getInstance();
        TileType source = board.getTile(x, y).getType();
        TileType destination = board.terrain.get(color);

        int sourceIndex = board.tileorder.indexOf(source); 
        int destinationIndex = board.tileorder.indexOf(destination);

        return Math.abs(sourceIndex - destinationIndex);
    }

    public void TransformTile(String color) {
        Board board = Board.getInstance();
        TileType desired = board.terrain.get(color);
        if(this.getType() == desired) {
            return;
        } 
        else {
            this.setType(desired);
        }
    }
}

