package terra.round.scoring;

public enum ScoringTileType {
    PLACE_DWELLING_BLUE,
    PLACE_DWELLING_RED,
    PLACE_TRADING_WHITE,
    PLACE_TRADING_BLUE,
    PLACE_TEMPLE,
    PLACE_STRONGTUARY_WHITE,
    PLACE_STRONGTUARY_RED,
    TRANSFORM,
    FOUND_TOWN;

    public String toString() {
        switch(this) {
        case FOUND_TOWN:
            return "Found a Town";
        case PLACE_DWELLING_BLUE:
            return "Place a Dwelling Blue";
        case PLACE_DWELLING_RED:
            return "Place a Dwelling Red";
        case PLACE_STRONGTUARY_RED:
            return "Place a stronghold or a sanctuary Red";
        case PLACE_STRONGTUARY_WHITE:
            return "Place a stronghold or a sanctuary White";
        case PLACE_TEMPLE:
            return "Place a Temple";
        case PLACE_TRADING_BLUE:
            return "Place a Trading House Blue";
        case PLACE_TRADING_WHITE:
            return "Place a Trading House White";
        case TRANSFORM:
            return "Transform a Tile";
        default:
            return "Invalid Scoring Tile Type";
        }
    }
}
