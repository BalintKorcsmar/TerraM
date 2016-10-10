package terra.main;

import terra.board.Board;
import terra.board.Tile;
import terra.player.ChaosMagician;
import terra.unit.BuildingType;

public class TerraMain {

    public static void main(String[] args) {

        Board board = Board.getInstance();
        ChaosMagician red = ChaosMagician.getInstance();
        red.print();

        red.getDashboard().print();

        Tile tile = board.getTile(6, 5);
        tile.print();

        red.TransformAndBuild(6, 5);
        tile = board.getTile(6, 5);
        tile.print();
        red.print();

        red.TransformAndBuild(6, 6);
        tile = board.getTile(6, 6);
        tile.print();
        red.print();

        red.TransformAndBuild(7, 9);
        tile = board.getTile(7, 9);
        tile.print();
        red.print();

        red.TransformAndBuild(6, 5);
        tile = board.getTile(6, 5);

        red.UpgradeStructure(6, 5, BuildingType.SANCTUARY);
        tile.print();
        red.print();

        red.UpgradeStructure(6, 5, BuildingType.TRADING_HOUSE);
        tile.print();
        red.print();

        red.UpgradeStructure(6, 5, BuildingType.STRONGHOLD);
        tile.print();
        red.print();

        tile = board.getTile(7, 9);
        red.UpgradeStructure(7, 9, BuildingType.TRADING_HOUSE);
        tile.print();
        red.print();

        red.UpgradeStructure(7, 9, BuildingType.TEMPLE);
        tile.print();
        red.print();

        tile = board.getTile(8, 7);
        red.TransformAndBuild(8, 7);
        tile.print();
        red.print();

        red.UpgradeStructure(8, 7, BuildingType.TRADING_HOUSE);
        tile.print();
        red.print();

        red.UpgradeStructure(8, 7, BuildingType.TEMPLE);
        tile.print();
        red.print();

        red.UpgradeStructure(8, 7, BuildingType.SANCTUARY);
        tile.print();
        red.print();

        red.getDashboard().print();
    }
}
