package Contoller;

import Model.GameState;
import View.View;
import View.SelectionScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controller {

    private GameState gameState;
    private View view;

    private final Stack<List<Integer>> lastMoves;

    public Controller() {
        lastMoves = new Stack<>();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void startNewGame(String player1Name, String player2Name, int player1Type, int player2Type) {
        gameState = new GameState(player1Name, player2Name, player1Type, player2Type);
        view.setGameRunning(true);
        view.playerTurnLabel.setText(gameState.getMessage());
        view.playerXLabel.setText("X: " + gameState.getPlayer1Name());
        view.playerOLabel.setText("O: " + gameState.getPlayer2Name());
        if (gameState.isComputersTurn()) {
            updateGameState();
        }
    }

    public void updateGameState() {
        gameState.updateGame();

        int xCoord = gameState.getCurrentSpace()[0];
        int yCoord = gameState.getCurrentSpace()[1];
        saveLastMove(xCoord, yCoord);
        view.update(xCoord, yCoord, gameState.getCurrentMark());

        if(gameState.isGameOver()){
            view.gameIsOver();
            view.playerTurnLabel.setText(gameState.getMessage());
            lastMoves.clear();
        } else{
            gameState.switchPlayers();
            view.playerTurnLabel.setText(gameState.getMessage());
            if (gameState.isComputersTurn() && !gameState.isGameOver()) {
                updateGameState();
            }
        }
    }

    private void saveLastMove(int xCoord, int yCoord) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(xCoord);
        list.add(yCoord);
        lastMoves.push(list);

    }

    public void setRequest(ArrayList<Integer> position) {
        gameState.setHumanPlayersPick(position.stream().mapToInt(i -> i).toArray());
        updateGameState();
    }

    public void resetGame() {
        gameState = null;
        lastMoves.clear();
        System.gc();
        new SelectionScreen(this);
    }

    public void undoMove() {
        if(lastMoves.isEmpty()){
            JOptionPane.showMessageDialog(null, "No moves to undo", "Empty",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            List<Integer> lastTurn = lastMoves.pop();

            gameState.undoBoardMove(lastTurn.stream().mapToInt(i -> i).toArray());
            gameState.switchPlayers();
            view.playerTurnLabel.setText(gameState.getMessage());
            view.undoLastTurn(lastTurn.stream().mapToInt(i -> i).toArray());

            if(gameState.isComputersTurn()) {
                List<Integer> computersLastTurn = lastMoves.pop();
                gameState.undoBoardMove(computersLastTurn.stream().mapToInt(i -> i).toArray());
                gameState.switchPlayers();
                view.undoLastTurn(computersLastTurn.stream().mapToInt(i -> i).toArray());
            }
        }
    }
}
