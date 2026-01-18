package Model;

import Contoller.GameControls;
import Model.players.ComputerPlayer;
import Model.players.Player;

public class GameState implements GameControls {

    private Board board;
    private int turn;
    private final Player[] players;
    private String currentMark;
    private String message;
    private int[] currentSpace;
    private boolean gameOver;
    private final Player player1;
    private final Player player2;

    public GameState(Player player1, Player player2) {
        this.board = new Board();
        this.turn = 0;
        this.player1 = player1;
        this.player2 = player2;
        this.players = new Player[]{player1, player2};
        addBoardToPlayers();
        this.gameOver = false;
        this.message = players[turn].getPlayerMessage();

    }
    
    @Override
    public void updateGame() {
        Player current = players[turn];
        int playersPick = current.pickASpace();
        board.placePlayersMark(playersPick, current.getPlayersMark());
        currentSpace = board.mapToCoordinates(playersPick);
        currentMark = current.getPlayersMark();
        if (evaluateGameOver(current)) {
            gameOver = true;
        }
    }
    private void addBoardToPlayers() {
        for (Player player : players) {
            if ( player.isComputer() ){
                ((ComputerPlayer) player).setBoard(board);
            }
        }
    }

    @Override
    public void switchPlayers() {
        turn = (turn + 1) % 2;
        message = players[turn].getPlayerMessage();
    }

    @Override
    public boolean isComputersTurn() {
        return players[turn].isComputer();
    }

    private boolean evaluateGameOver(Player current) {
        if (board.checkWinner(current.getPlayersMark())) {
            message = current.getPlayerName() + " wins!";
            return true;
        }
        if (board.boardIsFull()) {
            message = "It's a draw!";
            return true;
        }
        return false;
    }

    @Override
    public void setHumanPlayersPick(int[] position) {
        int pick = board.coordinatesToMap(position);
        players[turn].setPlayerPick(pick);
    }

    @Override
    public void undoBoardMove(int[] position) {
        int move = board.coordinatesToMap(position);
        board.placePlayersMark(move, String.valueOf(move));
    }

    @Override
    public String getCurrentMark() {
        return currentMark;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int[] getCurrentSpace() {
        return currentSpace;
    }

    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public String getPlayer1Name() {
        return player1.getPlayerName();
    }

    @Override
    public String getPlayer2Name() {
        return player2.getPlayerName();
    }
}
