package terra.board;

import java.util.Optional;

import terra.dashboard.NoMoreBuildingException;
import terra.player.PlayerAccess;
import terra.unit.Building;
import terra.unit.BuildingType;

public class Tile {
    private int row, column;
//    private Building building;
    private Optional<Building> building;
    private TileType type;

    public Tile(int row, int column, TileType type) {
        if(row < 0 || row > 8 || column < 0 || column > 12) {
            throw new IllegalArgumentException(" Invalid input argument for Tile() !");
        }
        this.setRow(row);
        this.setColumn(column);
        building = Optional.empty();
        this.setType(type);
    }

    public int getRow() {
        return row;
    }

    private void setRow(int x) {
        this.row = x;
    }

    public int getColumn() {
        return column;
    }

    private void setColumn(int y) {
        this.column = y;
    }

    public Optional<Building> getBuilding() {
        return building;
    }

    public boolean setBuilding(BuildingType buildingType, String color) throws TileNotEmptyException,
                                                                            InvalidUpgradeException,
                                                                            InvalidBuildException,
                                                                            NoMoreBuildingException,
                                                                            InvalidColorException {
        boolean result = false;

        if(this.getType() == TileType.RIVER) {
            throw new InvalidBuildException(buildingType, this.getType());
        }
        if(this.getBuilding().isPresent()) {
            if( buildingType == BuildingType.DWELLING) {
                throw new TileNotEmptyException(this.getBuilding().get());
            }
            if(this.getBuilding().get().getColor() != color) {
                throw new InvalidColorException(this.getBuilding().get().getBuildingType(), buildingType,
                                                this.getBuilding().get().getColor(), color);
            }
            switch(this.getBuilding().get().getBuildingType()) {
                case DWELLING:
                    if(buildingType == BuildingType.TRADING_HOUSE) {
                        this.building = Optional.of(PlayerAccess.getInstance().getPlayer().getDashboard().getBuilding(buildingType, color));
                        result = true;
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
                        this.building = Optional.of(PlayerAccess.getInstance().getPlayer().getDashboard().getBuilding(buildingType, color));
                        result = true;
                    } 
                    else {
                        throw new InvalidUpgradeException(this.getBuilding().get().getBuildingType(), buildingType);
                    }
                    break;
                case TRADING_HOUSE:
                    if(buildingType == BuildingType.STRONGHOLD ||
                       buildingType == BuildingType.TEMPLE) {
                        this.building = Optional.of(PlayerAccess.getInstance().getPlayer().getDashboard().getBuilding(buildingType, color));
                        result = true;
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
                this.building = Optional.of(PlayerAccess.getInstance().getPlayer().getDashboard().getBuilding(buildingType, color));
                result = true;
            }
            else {
                throw new InvalidBuildException(buildingType, this.getType());
            }
        }
        return result;
    }

    public TileType getType() {
        return this.type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public int getSteps(int x, int y, String color) {
        Board board = Board.getInstance();
        TileType source = board.getTile(x, y).getType();
        TileType destination = board.terrain.get(color);

        int sourceIndex = board.tileorder.indexOf(source); 
        int destinationIndex = board.tileorder.indexOf(destination);

        int distance = Math.abs(sourceIndex - destinationIndex);
        if(distance == 6) {
            distance = 1;
        } else if(distance == 5) {
            distance = 2;
        } else if(distance == 4) {
            distance = 3;
        }
        return distance;
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

    public boolean isNeighbor() {

        Tile tile = Board.getInstance().getTile(this.getRow() - 1, this.getColumn());
        if(tile != null) {
            if(tile.getBuilding().isPresent()) {
                if(tile.getType() != this.getType()) {
                    return true;
                }
            }
        }

        tile = Board.getInstance().getTile(this.getRow() + 1, this.getColumn());
        if(tile != null) {
            if(tile.getBuilding().isPresent()) {
                if(tile.getType() != this.getType()) {
                    return true;
                }
            }
        }

        tile = Board.getInstance().getTile(this.getRow(), this.getColumn() - 1);
        if(tile != null) {
            if(tile.getBuilding().isPresent()) {
                if(tile.getType() != this.getType()) {
                    return true;
                }
            }
        }

        tile = Board.getInstance().getTile(this.getRow(), this.getColumn() + 1);
        if(tile != null) {
            if(tile.getBuilding().isPresent()) {
                if(tile.getType() != this.getType()) {
                    return true;
                }
            }
        }
        /* Odd case*/
        if(this.getRow() % 2 == 1) {
            tile = Board.getInstance().getTile(this.getRow() + 1, this.getColumn() - 1);
            if(tile != null) {
                if(tile.getBuilding().isPresent()) {
                    if(tile.getType() != this.getType()) {
                        return true;
                    }
                }
            }
            tile = Board.getInstance().getTile(this.getRow() + 1, this.getColumn() + 1);
            if(tile != null) {
                if(tile.getBuilding().isPresent()) {
                    if(tile.getType() != this.getType()) {
                        return true;
                    }
                }
            }
        }
        /* Even case */
        else {
            tile = Board.getInstance().getTile(this.getRow() - 1, this.getColumn() - 1);
            if(tile != null) {
                if(tile.getBuilding().isPresent()) {
                    if(tile.getType() != this.getType()) {
                        return true;
                    }
                }
            }

            tile = Board.getInstance().getTile(this.getRow() - 1, this.getColumn() + 1);
            if(tile != null) {
                if(tile.getBuilding().isPresent()) {
                    if(tile.getType() != this.getType()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void print() {
        if(this.getBuilding().isPresent()) {
            System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", this.getRow() + 1, this.getColumn() + 1,
                                                                                     this.getType().toString(),
                                                                                     this.getBuilding().get().getColor(),
                                                                                     this.getBuilding().get().toString());
        }
        else {
            System.out.format("\n\nThe %d/%d %s tile is empty.\n", this.getRow() + 1, this.getColumn() + 1,
                                                                   this.getType().toString());
        }
    }
}

