package Model.players;
public class HumanPlayer extends Player {
    HumanPlayer(String playerName, String playersMark) {
        super(playerName, playersMark, false);
        setPlayerMessage("It is " + getPlayerName() + "'s turn");
    }

    public String getPlayerName() {
        return super.getPlayerName();
    }

    public String getPlayersMark() {
        return super.getPlayersMark();
    }

    public int pickASpace() {
        return getPlayersPick();
    }
}
