package terra.round;

public class Round {

    private static Round instance = new Round();

    private int roundNumber;

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
