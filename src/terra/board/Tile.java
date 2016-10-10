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
                throw new InvalidBuildException(building);
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

    public String TypeToString() {
        switch(this.getType()) {
        case DESERT:
            return "Desert";
        case FOREST:
            return "Forest";
        case LAKES:
            return "Lakes";
        case MOUNTAINS:
            return "Mountains";
        case PLAINS:
            return "Plains";
        case RIVER:
            return "River";
        case SWAMP:
            return "Swamp";
        case WASTELAND:
            return "Wasteland";
        default:
            return "Invalid";
        }
        
    }

    public void TransformTile(String color) {
        TileType desired = Board.terrain.get(color);
        if(this.getType() == desired) {
            return;
        } 
        else {
            this.setType(desired);
        }
    }
}

