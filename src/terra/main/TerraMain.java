package terra.main;

import terra.board.Board;
import terra.board.Tile;
import terra.player.Player;
import terra.player.PlayerAccess;
import terra.round.Round;
import terra.unit.BuildingType;

class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;
    
    RunnableDemo( String name) {
       threadName = name;
       System.out.println("Creating " +  threadName );
    }
    
    public void run() {
       System.out.println("Running " +  threadName );
       try {
          for(int i = 0; i < 10; i++) {
              if(this.t.getName() == "Thread A") {
                  if(i % 4 == 1) {
                      System.out.format("The current thread: %s yields.\n", this.t.getName());
                      Thread.yield();
                  }
              }
             System.out.println("Thread: " + threadName + ", " + i);
             // Let the thread sleep for a while.
             Thread.sleep(500);
          }
       }catch (InterruptedException e) {
          System.out.println("Thread " +  threadName + " interrupted.");
       }
       System.out.println("Thread " +  threadName + " exiting.");
    }
    
    public void start (int priority) {
       System.out.println("Starting " +  threadName );
       if (t == null) {
          t = new Thread (this, threadName);
          t.setPriority(priority);
          t.start ();
       }
    }
 }
public class TerraMain {

    public static void main(String[] args) {

        Board board = Board.getInstance();
        Round round = Round.getInstance();
        PlayerAccess playerAccess = PlayerAccess.getInstance(4);
        playerAccess.print();

        round.print();

        Player player1 = playerAccess.getPlayer();
        player1.print();

        player1.getDashboard().print();

        Tile tile = board.getTile(6, 5);
        tile.print();

        player1.TransformAndBuild(6, 5);
        tile = board.getTile(6, 5);
        tile.print();
        player1.print();

        player1 = playerAccess.getPlayer();
        player1.TransformAndBuild(6, 6); /* River */
        tile = board.getTile(6, 6);
        tile.print();
        player1.print();

        player1 = playerAccess.getPlayer();
        player1.TransformAndBuild(7, 9);
        tile = board.getTile(7, 9);
        tile.print();
        player1.print();

        player1 = playerAccess.getPlayer();
        player1.TransformAndBuild(2, 2);
        tile = board.getTile(2, 2);
        tile.print();
        player1.print();

        player1 = playerAccess.getPlayer();
        player1.TransformAndBuild(5, 4);
        tile = board.getTile(5, 4);
        tile.print();
        player1.print();

        player1 = playerAccess.getPlayer();
        player1.TransformAndBuild(6, 5);
        tile = board.getTile(6, 5);

        player1.UpgradeStructure(6, 5, BuildingType.SANCTUARY);
        tile.print();
        player1.print();

        player1.UpgradeStructure(6, 5, BuildingType.TRADING_HOUSE);
        tile.print();
        player1.print();

        player1.UpgradeStructure(6, 5, BuildingType.STRONGHOLD);
        tile.print();
        player1.print();

        tile = board.getTile(7, 9);
        player1.UpgradeStructure(7, 9, BuildingType.TRADING_HOUSE);
        tile.print();
        player1.print();

        player1.UpgradeStructure(7, 9, BuildingType.TEMPLE);
        tile.print();
        player1.print();

        tile = board.getTile(8, 7);
        player1.TransformAndBuild(8, 7);
        tile.print();
        player1.print();

        player1.UpgradeStructure(8, 7, BuildingType.TRADING_HOUSE);
        tile.print();
        player1.print();

        player1.UpgradeStructure(8, 7, BuildingType.TEMPLE);
        tile.print();
        player1.print();

        player1.UpgradeStructure(8, 7, BuildingType.SANCTUARY);
        tile.print();
        player1.print();

        player1.getDashboard().print();

        RunnableDemo R1 = new RunnableDemo("Thread A");
        R1.start(4);
        RunnableDemo R2 = new RunnableDemo("Thread B");
        R2.start(4);
    }
}
