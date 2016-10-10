package terra.player;

public class PlayerAccess {

    public PlayerAccess() {

    }
    
    public static Player getPlayer(String color) {
        switch(color) {
            case "RED" :
                return ChaosMagician.getInstance();
            default:
                return null;
        }
    }
}
