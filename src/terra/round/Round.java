package terra.round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import terra.round.scoring.*;

public class Round {

    private static Round instance = new Round();

    private int roundNumber;
    private static final List<ScoringTile> scoringTiles = new ArrayList<ScoringTile>(Arrays.asList(
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.PLACE_DWELLING_BLUE),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.PLACE_DWELLING_RED),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.PLACE_TRADING_WHITE),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.PLACE_TRADING_BLUE),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.PLACE_TEMPLE),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.PLACE_STRONGTUARY_WHITE),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.PLACE_STRONGTUARY_RED),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.TRANSFORM),
            new ScoringTile.ScoringTileBuilder().build(ScoringTileType.FOUND_TOWN)));
    
    private Round() {
        this.setRoundNumber(1);
    }

    public static Round getInstance() {
        return instance;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void EndRound() {
        if(getRoundNumber() == 6) {
            this.EndGame();
        }
        this.setRoundNumber(getRoundNumber() + 1);
        
    }

    public void EndGame() {
        
    }

}
