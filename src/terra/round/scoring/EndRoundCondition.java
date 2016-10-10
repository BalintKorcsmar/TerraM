package terra.round.scoring;

public enum EndRoundCondition {
    FOUR_BLUE, FOUR_RED, FOUR_WHITE, FOUR_BROWN, TWO_WHITE, TWO_RED, ONE_BROWN, PLACE_PRIEST;

    @Override
    public String toString() {
        switch(this) {
        case FOUR_BLUE:
            return "Four Blue";
        case FOUR_BROWN:
            return "Four Brown";
        case FOUR_RED:
            return "Four Red";
        case FOUR_WHITE:
            return "Four White";
        case ONE_BROWN:
            return "One Brown";
        case PLACE_PRIEST:
            return "Place a priest to the cultist track";
        case TWO_RED:
            return "Two Red";
        case TWO_WHITE:
            return "Two White";
        default:
            return "Invalid End Round Condition!";
        
        }
    }
}
