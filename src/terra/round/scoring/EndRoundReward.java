package terra.round.scoring;

public enum EndRoundReward {
    TRANSFORM, PRIEST, WORKER, GOLD, TWO_GOLD, FOUR_MANA;

    public String toString() {
        switch(this) {
        case FOUR_MANA:
            return "Four Mana";
        case GOLD:
            return "One Gold";
        case PRIEST:
            return "One Prist";
        case TRANSFORM:
            return "One Transform";
        case TWO_GOLD:
            return "Two Golds";
        case WORKER:
            return "One Worker";
        default:
            return "Invalid Value";
        }
    }
}
