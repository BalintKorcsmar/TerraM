package terra.round.scoring;
/**
 * 
 * @author ekorbal
 * This is an immutable class.
 */
public final class ScoringTile {

    private final RequiredAction action;
    private final EndRoundCondition condition;
    private final EndRoundReward reward;

    private ScoringTile(ScoringTileBuilder builder) {
        this.action = builder.action;
        this.condition = builder.condition;
        this.reward = builder.reward;
    }

    public RequiredAction getAction() {
        return action;
    }

    public EndRoundCondition getCondition() {
        return condition;
    }

    public EndRoundReward getReward() {
        return reward;
    }

    public static class ScoringTileBuilder {
        private RequiredAction action;
        private EndRoundCondition condition;
        private EndRoundReward reward;

        public ScoringTileBuilder() {}
        
        public ScoringTileBuilder action(RequiredAction action) {
            this.action = action;
            return this;
        }

        public ScoringTileBuilder condition(EndRoundCondition condition) {
            this.condition = condition;
            return this;
        }

        public ScoringTileBuilder reward(EndRoundReward reward) {
            this.reward = reward;
            return this;
        }

        public ScoringTile build() {
            ScoringTile tile = new ScoringTile(this);
            return tile;
        }

        public ScoringTile build(ScoringTileType type) {
            switch (type) {
            case FOUND_TOWN:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.FOUND_TOWN).condition(EndRoundCondition.FOUR_BROWN).reward(EndRoundReward.TRANSFORM).build();
            case PLACE_DWELLING_BLUE:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.BUILD_DWELLING).condition(EndRoundCondition.FOUR_BLUE).reward(EndRoundReward.PRIEST).build();
            case PLACE_DWELLING_RED:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.BUILD_DWELLING).condition(EndRoundCondition.FOUR_RED).reward(EndRoundReward.FOUR_MANA).build();
            case PLACE_STRONGTUARY_RED:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.BUILD_STRONGTUARY).condition(EndRoundCondition.TWO_RED).reward(EndRoundReward.WORKER).build();
            case PLACE_STRONGTUARY_WHITE:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.BUILD_STRONGTUARY).condition(EndRoundCondition.TWO_WHITE).reward(EndRoundReward.WORKER).build();
            case PLACE_TEMPLE:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.BUILD_TEMPLE).condition(EndRoundCondition.PLACE_PRIEST).reward(EndRoundReward.TWO_GOLD).build();
            case PLACE_TRADING_BLUE:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.BUILD_TRADING_HOUSE).condition(EndRoundCondition.FOUR_BLUE).reward(EndRoundReward.TRANSFORM).build();
            case PLACE_TRADING_WHITE:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.BUILD_TRADING_HOUSE).condition(EndRoundCondition.FOUR_WHITE).reward(EndRoundReward.TRANSFORM).build();
            case TRANSFORM:
                return new ScoringTile.ScoringTileBuilder().action(RequiredAction.TRANSFORM).condition(EndRoundCondition.ONE_BROWN).reward(EndRoundReward.GOLD).build();
            default:
                return null;
            
            }
        }
    }
}
