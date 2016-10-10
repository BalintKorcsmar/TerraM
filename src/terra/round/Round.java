package terra.round;

import java.util.List;
import terra.round.scoring.*;

public class Round {

    private static Round instance = new Round();

    private int roundNumber;
    private static final List<ScoringTile> scoringTiles = ScoringTile.drawTiles();

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

    public void print() {
        System.out.println("The chosen Scoring Tiles for this game are:");
        int i = 0;
        for(ScoringTile sc : scoringTiles) {
            i++;
            System.out.format("Round %d: The Required action is %s. The reward is %s per every %s.\n",
                              i, sc.getAction().toString(), sc.getReward().toString(), sc.getCondition().toString());
        }
    }
    public void EndGame() {
        
    }

}
