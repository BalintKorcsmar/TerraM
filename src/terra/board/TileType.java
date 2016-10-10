package terra.board;

public enum TileType {

    PLAINS, SWAMP, LAKES, FOREST, MOUNTAINS, WASTELAND, DESERT, RIVER;

    public String ToString() {
        switch(this) {
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

    
}
