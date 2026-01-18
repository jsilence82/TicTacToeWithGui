package Contoller;

import Model.GameStateFactory;
import View.UIControl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controller {

    private GameControls gameControl;
    private UIControl uiControl;
    private Timer timer;

    private final Stack<List<Integer>> lastMoves;

    public Controller() {
        lastMoves = new Stack<>();
    }

    public void setUiControl(UIControl view) {
        this.uiControl = view;
    }

    public void startNewGame(String player1Name, String player2Name, String player1Type, String player2Type) {
        gameControl = GameStateFactory.createGameState(player1Name, player2Name, player1Type, player2Type);
        uiControl.setPlayerTurnLabel(gameControl.getMessage());
        uiControl.setPlayerXLabel(gameControl.getPlayer1Name());
        uiControl.setPlayerOLabel(gameControl.getPlayer2Name());
        if (gameControl.isComputersTurn()) {
            waitTwoSeconds();
        }
    }

    public void updateGameState() {
        gameControl.updateGame();
        int xCoord = gameControl.getCurrentSpace()[0];
        int yCoord = gameControl.getCurrentSpace()[1];
        saveLastMove(xCoord, yCoord);
        uiControl.update(xCoord, yCoord, gameControl.getCurrentMark());
        if (gameControl.isGameOver()) {
            uiControl.gameIsOver();
            uiControl.setPlayerTurnLabel(gameControl.getMessage());
            lastMoves.clear();
        } else {
            gameControl.switchPlayers();
            uiControl.setPlayerTurnLabel(gameControl.getMessage());
            if (gameControl.isComputersTurn() && !gameControl.isGameOver()) {
                waitTwoSeconds();
            }
        }
    }

    private void waitTwoSeconds() {
        timer = new Timer(1000, e -> {
            updateGameState();
            timer.stop();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void saveLastMove(int xCoord, int yCoord) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(xCoord);
        list.add(yCoord);
        lastMoves.push(list);
    }

    public void setRequest(ArrayList<Integer> position) {
        gameControl.setHumanPlayersPick(position.stream().mapToInt(i -> i).toArray());
        updateGameState();
    }

    public void resetGame() {
        gameControl = null;
        lastMoves.clear();
    }

    public void undoMove() {
        if (lastMoves.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No moves to undo", "Empty",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            List<Integer> lastTurn = lastMoves.pop();

            gameControl.undoBoardMove(lastTurn.stream().mapToInt(i -> i).toArray());
            gameControl.switchPlayers();

            uiControl.undoLastTurn(lastTurn.stream().mapToInt(i -> i).toArray());

            if (gameControl.isComputersTurn()) {
                List<Integer> computersLastTurn = lastMoves.pop();
                gameControl.undoBoardMove(computersLastTurn.stream().mapToInt(i -> i).toArray());
                gameControl.switchPlayers();
                uiControl.undoLastTurn(computersLastTurn.stream().mapToInt(i -> i).toArray());
            }
            uiControl.setPlayerTurnLabel(gameControl.getMessage());
        }
    }
}
