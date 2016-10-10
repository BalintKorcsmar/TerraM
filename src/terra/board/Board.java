package terra.board;

import java.util.*;

public class Board {
    private static Tile [][] tiles = new Tile[9][13];

    public static Hashtable <String, TileType> terrain = new Hashtable<String, TileType>(7);

    private static List<TileType> tileorder = new ArrayList<TileType>();
    private static Board instance =  new Board();

    private Board() {
        Board.tiles[0][0] = new Tile(0, 0, TileType.PLAINS);
        Board.tiles[0][1] = new Tile(0, 1, TileType.MOUNTAINS);
        Board.tiles[0][2] = new Tile(0, 2, TileType.FOREST);
        Board.tiles[0][3] = new Tile(0, 3, TileType.LAKES);
        Board.tiles[0][4] = new Tile(0, 4, TileType.DESERT);
        Board.tiles[0][5] = new Tile(0, 5, TileType.WASTELAND);
        Board.tiles[0][6] = new Tile(0, 6, TileType.PLAINS);
        Board.tiles[0][7] = new Tile(0, 7, TileType.SWAMP);
        Board.tiles[0][8] = new Tile(0, 8, TileType.WASTELAND);
        Board.tiles[0][9] = new Tile(0, 9, TileType.FOREST);
        Board.tiles[0][10] = new Tile(0, 10, TileType.LAKES);
        Board.tiles[0][11] = new Tile(0, 11, TileType.WASTELAND);
        Board.tiles[0][12] = new Tile(0, 12, TileType.SWAMP);

        Board.tiles[1][0] = new Tile(1, 0, TileType.DESERT);
        Board.tiles[1][1] = new Tile(1, 1, TileType.RIVER);
        Board.tiles[1][2] = new Tile(1, 2, TileType.RIVER);
        Board.tiles[1][3] = new Tile(1, 3, TileType.PLAINS);
        Board.tiles[1][4] = new Tile(1, 4, TileType.SWAMP);
        Board.tiles[1][5] = new Tile(1, 5, TileType.RIVER);
        Board.tiles[1][6] = new Tile(1, 6, TileType.RIVER);
        Board.tiles[1][7] = new Tile(1, 7, TileType.DESERT);
        Board.tiles[1][8] = new Tile(1, 8, TileType.SWAMP);
        Board.tiles[1][9] = new Tile(1, 9, TileType.RIVER);
        Board.tiles[1][10] = new Tile(1, 10, TileType.RIVER);
        Board.tiles[1][11] = new Tile(1, 11, TileType.DESERT);
        Board.tiles[1][12] = null;

        Board.tiles[2][0] = new Tile(2, 0, TileType.RIVER);
        Board.tiles[2][1] = new Tile(2, 1, TileType.RIVER);
        Board.tiles[2][2] = new Tile(2, 2, TileType.SWAMP);
        Board.tiles[2][3] = new Tile(2, 3, TileType.RIVER);
        Board.tiles[2][4] = new Tile(2, 4, TileType.MOUNTAINS);
        Board.tiles[2][5] = new Tile(2, 5, TileType.RIVER);
        Board.tiles[2][6] = new Tile(2, 6, TileType.FOREST);
        Board.tiles[2][7] = new Tile(2, 7, TileType.RIVER);
        Board.tiles[2][8] = new Tile(2, 8, TileType.FOREST);
        Board.tiles[2][9] = new Tile(2, 9, TileType.RIVER);
        Board.tiles[2][10] = new Tile(2, 10, TileType.MOUNTAINS);
        Board.tiles[2][11] = new Tile(2, 11, TileType.RIVER);
        Board.tiles[2][12] = new Tile(2, 12, TileType.RIVER);

        Board.tiles[3][0] = new Tile(3, 0, TileType.FOREST);
        Board.tiles[3][1] = new Tile(3, 1, TileType.LAKES);
        Board.tiles[3][2] = new Tile(3, 2, TileType.DESERT);
        Board.tiles[3][3] = new Tile(3, 3, TileType.RIVER);
        Board.tiles[3][4] = new Tile(3, 4, TileType.RIVER);
        Board.tiles[3][5] = new Tile(3, 5, TileType.WASTELAND);
        Board.tiles[3][6] = new Tile(3, 6, TileType.LAKES);
        Board.tiles[3][7] = new Tile(3, 7, TileType.RIVER);
        Board.tiles[3][8] = new Tile(3, 8, TileType.WASTELAND);
        Board.tiles[3][9] = new Tile(3, 9, TileType.RIVER);
        Board.tiles[3][10] = new Tile(3, 10, TileType.WASTELAND);
        Board.tiles[3][11] = new Tile(3, 11, TileType.PLAINS);
        Board.tiles[3][12] = null;

        Board.tiles[4][0] = new Tile(4, 0, TileType.SWAMP);
        Board.tiles[4][1] = new Tile(4, 1, TileType.PLAINS);
        Board.tiles[4][2] = new Tile(4, 2, TileType.WASTELAND);
        Board.tiles[4][3] = new Tile(4, 3, TileType.LAKES);
        Board.tiles[4][4] = new Tile(4, 4, TileType.SWAMP);
        Board.tiles[4][5] = new Tile(4, 5, TileType.PLAINS);
        Board.tiles[4][6] = new Tile(4, 6, TileType.MOUNTAINS);
        Board.tiles[4][7] = new Tile(4, 7, TileType.DESERT);
        Board.tiles[4][8] = new Tile(4, 8, TileType.RIVER);
        Board.tiles[4][9] = new Tile(4, 9, TileType.RIVER);
        Board.tiles[4][10] = new Tile(4, 10, TileType.FOREST);
        Board.tiles[4][11] = new Tile(4, 11, TileType.SWAMP);
        Board.tiles[4][12] = new Tile(4, 12, TileType.LAKES);;

        Board.tiles[5][0] = new Tile(5, 0, TileType.MOUNTAINS);
        Board.tiles[5][1] = new Tile(5, 1, TileType.FOREST);
        Board.tiles[5][2] = new Tile(5, 2, TileType.RIVER);
        Board.tiles[5][3] = new Tile(5, 3, TileType.RIVER);
        Board.tiles[5][4] = new Tile(5, 4, TileType.DESERT);
        Board.tiles[5][5] = new Tile(5, 5, TileType.FOREST);
        Board.tiles[5][6] = new Tile(5, 6, TileType.RIVER);
        Board.tiles[5][7] = new Tile(5, 7, TileType.RIVER);
        Board.tiles[5][8] = new Tile(5, 8, TileType.RIVER);
        Board.tiles[5][9] = new Tile(5, 9, TileType.PLAINS);
        Board.tiles[5][10] = new Tile(5, 10, TileType.MOUNTAINS);
        Board.tiles[5][11] = new Tile(5, 11, TileType.PLAINS);
        Board.tiles[5][12] = null;

        Board.tiles[6][0] = new Tile(6, 0, TileType.RIVER);
        Board.tiles[6][1] = new Tile(6, 1, TileType.RIVER);
        Board.tiles[6][2] = new Tile(6, 2, TileType.RIVER);
        Board.tiles[6][3] = new Tile(6, 3, TileType.MOUNTAINS);
        Board.tiles[6][4] = new Tile(6, 4, TileType.RIVER);
        Board.tiles[6][5] = new Tile(6, 5, TileType.WASTELAND);
        Board.tiles[6][6] = new Tile(6, 6, TileType.RIVER);
        Board.tiles[6][7] = new Tile(6, 7, TileType.FOREST);
        Board.tiles[6][8] = new Tile(6, 8, TileType.RIVER);
        Board.tiles[6][9] = new Tile(6, 9, TileType.DESERT);
        Board.tiles[6][10] = new Tile(6, 10, TileType.SWAMP);
        Board.tiles[6][11] = new Tile(6, 11, TileType.LAKES);
        Board.tiles[6][12] = new Tile(6, 12, TileType.DESERT);

        Board.tiles[7][0] = new Tile(7, 0, TileType.DESERT);
        Board.tiles[7][1] = new Tile(7, 1, TileType.LAKES);
        Board.tiles[7][2] = new Tile(7, 2, TileType.PLAINS);
        Board.tiles[7][3] = new Tile(7, 3, TileType.RIVER);
        Board.tiles[7][4] = new Tile(7, 4, TileType.RIVER);
        Board.tiles[7][5] = new Tile(7, 5, TileType.RIVER);
        Board.tiles[7][6] = new Tile(7, 6, TileType.LAKES);
        Board.tiles[7][7] = new Tile(7, 7, TileType.SWAMP);
        Board.tiles[7][8] = new Tile(7, 8, TileType.RIVER);
        Board.tiles[7][9] = new Tile(7, 9, TileType.MOUNTAINS);
        Board.tiles[7][10] = new Tile(7, 10, TileType.PLAINS);
        Board.tiles[7][11] = new Tile(7, 11, TileType.MOUNTAINS);
        Board.tiles[7][12] = null;

        Board.tiles[8][0] = new Tile(7, 0, TileType.WASTELAND);
        Board.tiles[8][1] = new Tile(7, 1, TileType.SWAMP);
        Board.tiles[8][2] = new Tile(7, 2, TileType.MOUNTAINS);
        Board.tiles[8][3] = new Tile(7, 3, TileType.LAKES);
        Board.tiles[8][4] = new Tile(7, 4, TileType.WASTELAND);
        Board.tiles[8][5] = new Tile(7, 5, TileType.FOREST);
        Board.tiles[8][6] = new Tile(7, 6, TileType.DESERT);
        Board.tiles[8][7] = new Tile(7, 7, TileType.WASTELAND);
        Board.tiles[8][8] = new Tile(7, 8, TileType.MOUNTAINS);
        Board.tiles[8][9] = new Tile(7, 9, TileType.RIVER);
        Board.tiles[8][10] = new Tile(7, 10, TileType.LAKES);
        Board.tiles[8][11] = new Tile(7, 11, TileType.FOREST);
        Board.tiles[8][12] = new Tile(7, 12, TileType.WASTELAND);

        Board.terrain.put("BROWN", TileType.PLAINS);
        Board.terrain.put("BLACK", TileType.SWAMP);
        Board.terrain.put("BLUE", TileType.LAKES);
        Board.terrain.put("GREEN", TileType.FOREST);
        Board.terrain.put("GREY", TileType.MOUNTAINS);
        Board.terrain.put("RED", TileType.WASTELAND);
        Board.terrain.put("YELLOW", TileType.DESERT);

        Board.tileorder.add(TileType.PLAINS);
        Board.tileorder.add(TileType.SWAMP);
        Board.tileorder.add(TileType.LAKES);
        Board.tileorder.add(TileType.FOREST);
        Board.tileorder.add(TileType.MOUNTAINS);
        Board.tileorder.add(TileType.WASTELAND);
        Board.tileorder.add(TileType.DESERT);

    }

    public static Board getInstance() {
        return instance;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
}
