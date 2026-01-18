package Model.players;

public class Factory {
    public static Player playerFactory(PlayerType playerType, String playersName, String playersMark) {
        return playerType.create(playersName, playersMark);
    }
}
