package terra.board;

import java.util.*;

public class Board {
    private Tile [][] tiles = new Tile[9][13];

    public Hashtable <String, TileType> terrain = new Hashtable<String, TileType>(7);

    public List<TileType> tileorder = new ArrayList<TileType>();

    private static Board instance =  new Board();

    private Board() {
        this.tiles[0][0] = new Tile(0, 0, TileType.PLAINS);
        this.tiles[0][1] = new Tile(0, 1, TileType.MOUNTAINS);
        this.tiles[0][2] = new Tile(0, 2, TileType.FOREST);
        this.tiles[0][3] = new Tile(0, 3, TileType.LAKES);
        this.tiles[0][4] = new Tile(0, 4, TileType.DESERT);
        this.tiles[0][5] = new Tile(0, 5, TileType.WASTELAND);
        this.tiles[0][6] = new Tile(0, 6, TileType.PLAINS);
        this.tiles[0][7] = new Tile(0, 7, TileType.SWAMP);
        this.tiles[0][8] = new Tile(0, 8, TileType.WASTELAND);
        this.tiles[0][9] = new Tile(0, 9, TileType.FOREST);
        this.tiles[0][10] = new Tile(0, 10, TileType.LAKES);
        this.tiles[0][11] = new Tile(0, 11, TileType.WASTELAND);
        this.tiles[0][12] = new Tile(0, 12, TileType.SWAMP);

        this.tiles[1][0] = new Tile(1, 0, TileType.DESERT);
        this.tiles[1][1] = new Tile(1, 1, TileType.RIVER);
        this.tiles[1][2] = new Tile(1, 2, TileType.RIVER);
        this.tiles[1][3] = new Tile(1, 3, TileType.PLAINS);
        this.tiles[1][4] = new Tile(1, 4, TileType.SWAMP);
        this.tiles[1][5] = new Tile(1, 5, TileType.RIVER);
        this.tiles[1][6] = new Tile(1, 6, TileType.RIVER);
        this.tiles[1][7] = new Tile(1, 7, TileType.DESERT);
        this.tiles[1][8] = new Tile(1, 8, TileType.SWAMP);
        this.tiles[1][9] = new Tile(1, 9, TileType.RIVER);
        this.tiles[1][10] = new Tile(1, 10, TileType.RIVER);
        this.tiles[1][11] = new Tile(1, 11, TileType.DESERT);
        this.tiles[1][12] = null;

        this.tiles[2][0] = new Tile(2, 0, TileType.RIVER);
        this.tiles[2][1] = new Tile(2, 1, TileType.RIVER);
        this.tiles[2][2] = new Tile(2, 2, TileType.SWAMP);
        this.tiles[2][3] = new Tile(2, 3, TileType.RIVER);
        this.tiles[2][4] = new Tile(2, 4, TileType.MOUNTAINS);
        this.tiles[2][5] = new Tile(2, 5, TileType.RIVER);
        this.tiles[2][6] = new Tile(2, 6, TileType.FOREST);
        this.tiles[2][7] = new Tile(2, 7, TileType.RIVER);
        this.tiles[2][8] = new Tile(2, 8, TileType.FOREST);
        this.tiles[2][9] = new Tile(2, 9, TileType.RIVER);
        this.tiles[2][10] = new Tile(2, 10, TileType.MOUNTAINS);
        this.tiles[2][11] = new Tile(2, 11, TileType.RIVER);
        this.tiles[2][12] = new Tile(2, 12, TileType.RIVER);

        this.tiles[3][0] = new Tile(3, 0, TileType.FOREST);
        this.tiles[3][1] = new Tile(3, 1, TileType.LAKES);
        this.tiles[3][2] = new Tile(3, 2, TileType.DESERT);
        this.tiles[3][3] = new Tile(3, 3, TileType.RIVER);
        this.tiles[3][4] = new Tile(3, 4, TileType.RIVER);
        this.tiles[3][5] = new Tile(3, 5, TileType.WASTELAND);
        this.tiles[3][6] = new Tile(3, 6, TileType.LAKES);
        this.tiles[3][7] = new Tile(3, 7, TileType.RIVER);
        this.tiles[3][8] = new Tile(3, 8, TileType.WASTELAND);
        this.tiles[3][9] = new Tile(3, 9, TileType.RIVER);
        this.tiles[3][10] = new Tile(3, 10, TileType.WASTELAND);
        this.tiles[3][11] = new Tile(3, 11, TileType.PLAINS);
        this.tiles[3][12] = null;

        this.tiles[4][0] = new Tile(4, 0, TileType.SWAMP);
        this.tiles[4][1] = new Tile(4, 1, TileType.PLAINS);
        this.tiles[4][2] = new Tile(4, 2, TileType.WASTELAND);
        this.tiles[4][3] = new Tile(4, 3, TileType.LAKES);
        this.tiles[4][4] = new Tile(4, 4, TileType.SWAMP);
        this.tiles[4][5] = new Tile(4, 5, TileType.PLAINS);
        this.tiles[4][6] = new Tile(4, 6, TileType.MOUNTAINS);
        this.tiles[4][7] = new Tile(4, 7, TileType.DESERT);
        this.tiles[4][8] = new Tile(4, 8, TileType.RIVER);
        this.tiles[4][9] = new Tile(4, 9, TileType.RIVER);
        this.tiles[4][10] = new Tile(4, 10, TileType.FOREST);
        this.tiles[4][11] = new Tile(4, 11, TileType.SWAMP);
        this.tiles[4][12] = new Tile(4, 12, TileType.LAKES);;

        this.tiles[5][0] = new Tile(5, 0, TileType.MOUNTAINS);
        this.tiles[5][1] = new Tile(5, 1, TileType.FOREST);
        this.tiles[5][2] = new Tile(5, 2, TileType.RIVER);
        this.tiles[5][3] = new Tile(5, 3, TileType.RIVER);
        this.tiles[5][4] = new Tile(5, 4, TileType.DESERT);
        this.tiles[5][5] = new Tile(5, 5, TileType.FOREST);
        this.tiles[5][6] = new Tile(5, 6, TileType.RIVER);
        this.tiles[5][7] = new Tile(5, 7, TileType.RIVER);
        this.tiles[5][8] = new Tile(5, 8, TileType.RIVER);
        this.tiles[5][9] = new Tile(5, 9, TileType.PLAINS);
        this.tiles[5][10] = new Tile(5, 10, TileType.MOUNTAINS);
        this.tiles[5][11] = new Tile(5, 11, TileType.PLAINS);
        this.tiles[5][12] = null;

        this.tiles[6][0] = new Tile(6, 0, TileType.RIVER);
        this.tiles[6][1] = new Tile(6, 1, TileType.RIVER);
        this.tiles[6][2] = new Tile(6, 2, TileType.RIVER);
        this.tiles[6][3] = new Tile(6, 3, TileType.MOUNTAINS);
        this.tiles[6][4] = new Tile(6, 4, TileType.RIVER);
        this.tiles[6][5] = new Tile(6, 5, TileType.WASTELAND);
        this.tiles[6][6] = new Tile(6, 6, TileType.RIVER);
        this.tiles[6][7] = new Tile(6, 7, TileType.FOREST);
        this.tiles[6][8] = new Tile(6, 8, TileType.RIVER);
        this.tiles[6][9] = new Tile(6, 9, TileType.DESERT);
        this.tiles[6][10] = new Tile(6, 10, TileType.SWAMP);
        this.tiles[6][11] = new Tile(6, 11, TileType.LAKES);
        this.tiles[6][12] = new Tile(6, 12, TileType.DESERT);

        this.tiles[7][0] = new Tile(7, 0, TileType.DESERT);
        this.tiles[7][1] = new Tile(7, 1, TileType.LAKES);
        this.tiles[7][2] = new Tile(7, 2, TileType.PLAINS);
        this.tiles[7][3] = new Tile(7, 3, TileType.RIVER);
        this.tiles[7][4] = new Tile(7, 4, TileType.RIVER);
        this.tiles[7][5] = new Tile(7, 5, TileType.RIVER);
        this.tiles[7][6] = new Tile(7, 6, TileType.LAKES);
        this.tiles[7][7] = new Tile(7, 7, TileType.SWAMP);
        this.tiles[7][8] = new Tile(7, 8, TileType.RIVER);
        this.tiles[7][9] = new Tile(7, 9, TileType.MOUNTAINS);
        this.tiles[7][10] = new Tile(7, 10, TileType.PLAINS);
        this.tiles[7][11] = new Tile(7, 11, TileType.MOUNTAINS);
        this.tiles[7][12] = null;

        this.tiles[8][0] = new Tile(8, 0, TileType.WASTELAND);
        this.tiles[8][1] = new Tile(8, 1, TileType.SWAMP);
        this.tiles[8][2] = new Tile(8, 2, TileType.MOUNTAINS);
        this.tiles[8][3] = new Tile(8, 3, TileType.LAKES);
        this.tiles[8][4] = new Tile(8, 4, TileType.WASTELAND);
        this.tiles[8][5] = new Tile(8, 5, TileType.FOREST);
        this.tiles[8][6] = new Tile(8, 6, TileType.DESERT);
        this.tiles[8][7] = new Tile(8, 7, TileType.WASTELAND);
        this.tiles[8][8] = new Tile(8, 8, TileType.MOUNTAINS);
        this.tiles[8][9] = new Tile(8, 9, TileType.RIVER);
        this.tiles[8][10] = new Tile(8, 10, TileType.LAKES);
        this.tiles[8][11] = new Tile(8, 11, TileType.FOREST);
        this.tiles[8][12] = new Tile(8, 12, TileType.WASTELAND);

        this.terrain.put("BROWN", TileType.PLAINS);
        this.terrain.put("BLACK", TileType.SWAMP);
        this.terrain.put("BLUE", TileType.LAKES);
        this.terrain.put("GREEN", TileType.FOREST);
        this.terrain.put("GREY", TileType.MOUNTAINS);
        this.terrain.put("RED", TileType.WASTELAND);
        this.terrain.put("YELLOW", TileType.DESERT);

        this.tileorder.add(TileType.PLAINS);
        this.tileorder.add(TileType.SWAMP);
        this.tileorder.add(TileType.LAKES);
        this.tileorder.add(TileType.FOREST);
        this.tileorder.add(TileType.MOUNTAINS);
        this.tileorder.add(TileType.WASTELAND);
        this.tileorder.add(TileType.DESERT);
    }

    public static Board getInstance() {
        return instance;
    }

    public Tile getTile(int row, int column) {
        if(row >= 0 && row <= 8 && column >= 0 && column <= 12) {
            return this.tiles[row][column];
        }
        else {
            return null;
        }
    }
}
