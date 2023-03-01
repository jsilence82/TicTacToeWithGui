package Model.players;

public abstract class Player {
    private final String playerName;
    private final String playersMark;
    private String playerMessage;
    private int playersPick;
    private final boolean isComputer;

    Player(String playerName, String playersMark, boolean isComputer) {
        this.playerName = playerName;
        this.playersMark = playersMark;
        this.isComputer = isComputer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayersMark() {
        return playersMark;
    }

    public String getPlayerMessage() {
        return playerMessage;
    }

    public void setPlayerMessage(String playerMessage) {
        this.playerMessage = playerMessage;
    }
    public boolean isComputer() {
        return isComputer;
    }

    public abstract int pickASpace();

    public void setPlayerPick(int pick) {
        this.playersPick = pick;
    }
    public int getPlayersPick() {
        return playersPick;
    }
}
