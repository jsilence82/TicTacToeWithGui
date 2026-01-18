
package View;



import Contoller.Controller;

public interface UIControl {

    public void setGameRunning();

    public void gameIsOver();

    public void update(int xCoord, int yCoord, String playersMark);

    public void setPlayerTurnLabel(String message);

    public void setPlayerXLabel(String player1Name);
    
    public void setPlayerOLabel(String player2Name);

    public void undoLastTurn(int[] lastTurn);

    public void setController(Controller controller);

    public void resetGame();

    public void launchGame();

    public void displayErrorMessage(String message);

    public boolean displayConfirmationMessage(String message);

}
