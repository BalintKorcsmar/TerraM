package terra.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PlayerAccess {

    private static PlayerAccess instance;
    private final LinkedList<Player> players;
//    private final Map<String, Player> players = PlayerAccess.PlayerDrawer.drawPlayers(this.getNumberOfPlayers());
    private int numberOfPlayers;
    private int currentPlayer;

    private PlayerAccess(int numPlayers) {
        numberOfPlayers = numPlayers;
        currentPlayer = 0;
        players = PlayerAccess.PlayerDrawer.drawPlayers(this.getNumberOfPlayers());
    }

    public static PlayerAccess getInstance(int numberOfPlayers) throws RuntimeException{
        if(instance == null) {
            instance =  new PlayerAccess(numberOfPlayers);
            return instance;
        }
        throw new RuntimeException("This method of the PlayerAccess class can only be used for initialization. ");
    }

    public static PlayerAccess getInstance() throws RuntimeException{
        if(instance == null) {
            throw new RuntimeException("The PlayerAccess class has to be initialized before used. ");
        }
        return instance;
    }

    public Player getPlayer() {
        return players.get(getCurrentPlayer());
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void incrementCurrentPlayer() {
        this.currentPlayer++;
        if(this.getCurrentPlayer() == this.getNumberOfPlayers()) {
            this.currentPlayer = 0;
        }
    }

    public void print() {
       System.out.println("The drawn players for this game are:");
       int i = 1;
       for(Player pl : players) {
            System.out.format("Player %d: %s\n", i++, pl.getFaction().toString());
        }
    }

    private static class PlayerDrawer {

        public static LinkedList<Player> drawPlayers(int numberOfPlayers) {
            List<FactionTypes> factionType = new ArrayList<FactionTypes> (Arrays.asList(
                    FactionTypes.getFactionType(0, true), FactionTypes.getFactionType(0, false),
                    FactionTypes.getFactionType(1, true), FactionTypes.getFactionType(1, false),
                    FactionTypes.getFactionType(2, true), FactionTypes.getFactionType(2, false),
                    FactionTypes.getFactionType(3, true), FactionTypes.getFactionType(3, false),
                    FactionTypes.getFactionType(4, true), FactionTypes.getFactionType(4, false),
                    FactionTypes.getFactionType(5, true), FactionTypes.getFactionType(5, false),
                    FactionTypes.getFactionType(6, true), FactionTypes.getFactionType(6, false)));
            LinkedList<Player> drawnPlayers = new LinkedList<Player>();
            Random color = new Random();
            Random type = new Random();
            int numPlayers = 0;

            while(numPlayers < numberOfPlayers) {
                int colorIndex = color.nextInt(7- numPlayers++);
                boolean typeIndex = type.nextBoolean();
                FactionTypes faction = factionType.get(typeIndex ? 2 * colorIndex + 1 : 2 * colorIndex);
                drawnPlayers.add(faction.getPlayer(faction));
                
                /* Remove both factions of the same color. */
                factionType.remove(2 * colorIndex);
                factionType.remove(2 * colorIndex);
            }
            return drawnPlayers;
        }
    }
}
