package terra.main;

import terra.board.Board;
import terra.board.Tile;
import terra.board.TileType;
import terra.player.RedPlayer;
import terra.unit.Building;
import terra.unit.BuildingFactory;
import terra.unit.BuildingType;

public class TerraMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BuildingFactory bFactory = new BuildingFactory();
        Building b1 = bFactory.getBuilding(BuildingType.DWELLING, "red");
        Building b2 = bFactory.getBuilding(BuildingType.TRADING_HOUSE, "red");
        Building b3 = bFactory.getBuilding(BuildingType.TEMPLE, "red");
        Building b4 = bFactory.getBuilding(BuildingType.SANCTUARY, "red");
        Building b5 = bFactory.getBuilding(BuildingType.STRONGHOLD, "red");
        
        b1.build();
        b2.build();
        b3.build();
        b4.build();
        b5.build();
        Tile trial = new Tile(0, 0, TileType.PLAINS);
        System.out.format("This is TileType: %s",trial.getType().toString());
        Board board = Board.getInstance();
        RedPlayer red = RedPlayer.getInstance();
        red.print();
        red.build(BuildingType.DWELLING);
        red.print();
        red.TransformAndBuild(6, 5);
        Tile tile = Board.getInstance().getTile(6, 5) ;
        System.out.format("\n\nThe building on the %d/%d tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, red.getColor(), tile.getBuilding().toString());
        red.print();
//        red.TransformAndBuild(6, 5);
        red.UpgradeStructure(6, 5, BuildingType.SANCTUARY);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.TypeToString(), red.getColor(), tile.getBuilding().toString());
        red.print();

        red.UpgradeStructure(6, 5, BuildingType.TRADING_HOUSE);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.TypeToString(), red.getColor(), tile.getBuilding().toString());
        red.print();

        red.UpgradeStructure(6, 5, BuildingType.STRONGHOLD);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.TypeToString(), red.getColor(), tile.getBuilding().toString());
        red.print();
        

    }

}
