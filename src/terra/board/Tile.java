package terra.board;

import java.util.Optional;

import terra.dashboard.NoMoreBuildingException;
import terra.player.PlayerAccess;
import terra.unit.Building;
import terra.unit.BuildingType;

public class Tile {
    private int x, y;
//    private Building building;
    private Optional<Building> building;
    private TileType type;

    public Tile(int x, int y, TileType type) {
        this.setX(x);
        this.setY(y);
        building = Optional.empty();
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

    public Optional<Building> getBuilding() {
        return building;
    }

    public void setBuilding(BuildingType buildingType, String color) throws TileNotEmptyException,
                                                                            InvalidUpgradeException,
                                                                            InvalidBuildException,
                                                                            NoMoreBuildingException {
        if(this.getType() == TileType.RIVER) {
            throw new InvalidBuildException(buildingType, this.getType());
        }
        if(this.getBuilding().isPresent()) {
            if( buildingType == BuildingType.DWELLING) {
                throw new TileNotEmptyException(this.getBuilding().get());
            }
            
            switch(this.getBuilding().get().getBuildingType()) {
                case DWELLING:
                    if(buildingType == BuildingType.TRADING_HOUSE) {
                        this.building = Optional.of(PlayerAccess.getPlayer(color).getDashboard().getBuilding(buildingType, color));
                    } 
                    else {
                        throw new InvalidUpgradeException(this.getBuilding().get().getBuildingType(), buildingType);
                    }
                    break;
                case SANCTUARY:
                    throw new InvalidUpgradeException(this.getBuilding().get().getBuildingType(), buildingType);
                case STRONGHOLD:
                    throw new InvalidUpgradeException(this.getBuilding().get().getBuildingType(), buildingType);
                case TEMPLE:
                    if(buildingType == BuildingType.SANCTUARY) {
                        this.building = Optional.of(PlayerAccess.getPlayer(color).getDashboard().getBuilding(buildingType, color));
                    } 
                    else {
                        throw new InvalidUpgradeException(this.getBuilding().get().getBuildingType(), buildingType);
                    }
                    break;
                case TRADING_HOUSE:
                    if(buildingType == BuildingType.STRONGHOLD ||
                       buildingType == BuildingType.TEMPLE) {
                        this.building = Optional.of(PlayerAccess.getPlayer(color).getDashboard().getBuilding(buildingType, color));
                    }
                    else {
                        throw new InvalidUpgradeException(this.getBuilding().get().getBuildingType(), buildingType);
                    }
                    break;
                default:
                    break;
                
            }
        }
        else {
            if(buildingType == BuildingType.DWELLING) {
                this.building = Optional.of(PlayerAccess.getPlayer(color).getDashboard().getBuilding(buildingType, color));
            }
            else {
                throw new InvalidBuildException(buildingType, this.getType());
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

    public void print() {
        if(this.getBuilding().isPresent()) {
            System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", this.getX() + 1, this.getY() + 1,
                                                                                     this.getType().toString(),
                                                                                     this.getBuilding().get().getColor(),
                                                                                     this.getBuilding().get().toString());
        }
        else {
            System.out.format("\n\nThe %d/%d %s tile is empty.\n", this.getX() + 1, this.getY() + 1,
                                                                   this.getType().toString());
        }
    }
}

