package Controller;

import java.util.ArrayList;

public interface GameControllerInterface {

    void startNewGame(String player1Name, String player2Name, String player1Type, String player2Type);

    void setRequest(ArrayList<Integer> position);

    void undoMove();

    void resetGame();
}
