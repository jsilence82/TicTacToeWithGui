package Contoller;

public interface GameControls {

    public void updateGame();

    public void switchPlayers();

    public void undoBoardMove(int[] position);

    public boolean isComputersTurn();

    public String getMessage();

    public String getPlayer1Name();

    public String getPlayer2Name();

    public int[] getCurrentSpace();

    public boolean isGameOver();

    public String getCurrentMark();

    public void setHumanPlayersPick(int[] position);

}
