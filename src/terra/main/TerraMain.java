package terra.main;

import terra.board.Board;
import terra.board.Tile;
import terra.player.RedPlayer;

import terra.unit.BuildingType;

public class TerraMain {

    public static void main(String[] args) {

        Board board = Board.getInstance();
        RedPlayer red = RedPlayer.getInstance();
        red.print();

        red.TransformAndBuild(6, 5);
        Tile tile = board.getTile(6, 5);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.getType().toString(), red.getColor(), tile.getBuilding().toString());
        red.print();

        red.TransformAndBuild(6, 6);
        tile = board.getTile(6, 6);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.getType().toString(), red.getColor(), tile.getBuilding().toString());
        red.print();

        red.TransformAndBuild(7, 9);
        tile = board.getTile(7, 9);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.getType().toString(), red.getColor(), tile.getBuilding().toString());
        red.print();

        red.TransformAndBuild(6, 5);
        tile = board.getTile(6, 5);

        red.UpgradeStructure(6, 5, BuildingType.SANCTUARY);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.getType().ToString(), red.getColor(), tile.getBuilding().toString());
        red.print();

        red.UpgradeStructure(6, 5, BuildingType.TRADING_HOUSE);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.getType().ToString(), red.getColor(), tile.getBuilding().toString());
        red.print();

        red.UpgradeStructure(6, 5, BuildingType.STRONGHOLD);
        System.out.format("\n\nThe building on the %d/%d %s tile is a %s %s.\n", tile.getX() + 1,tile.getY() + 1, tile.getType().ToString(), red.getColor(), tile.getBuilding().toString());
        red.print();
    }
}
