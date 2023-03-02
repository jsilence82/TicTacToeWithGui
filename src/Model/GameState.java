package Model;

import Model.players.Factory;
import Model.players.Player;

public class GameState {

    private final Board board;
    private int turn;
    private final Player[] players;
    private String currentMark;
    private String message;
    private int[] currentSpace;
    private boolean gameOver;
    private final Player player1;
    private final Player player2;

    public GameState(String player1Name, String player2Name, int player1Type, int player2Type) {
        this.board = new Board();
        this.turn = 0;
        this.player1 = createPlayer(player1Type, player1Name, "X", board);
        this.player2 = createPlayer(player2Type, player2Name, "O", board);
        this.players = new Player[]{player1, player2};
        this.gameOver = false;
        this.message = players[turn].getPlayerMessage();
    }

    public Player createPlayer(int playerType, String playerName, String playersMark, Board board) {
        return Factory.playerFactory(playerType, playerName, playersMark, board);
    }

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

    public void switchPlayers() {
        turn = (turn + 1) % 2;
        message = players[turn].getPlayerMessage();
    }

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

    public void setHumanPlayersPick(int[] position) {
        int pick = board.coordinatesToMap(position);
        players[turn].setPlayerPick(pick);
    }

    public void undoBoardMove(int[] position) {
        int move = board.coordinatesToMap(position);
        board.placePlayersMark(move, String.valueOf(move));
    }

    public String getCurrentMark() {
        return currentMark;
    }

    public String getMessage() {
        return message;
    }

    public int[] getCurrentSpace() {
        return currentSpace;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getPlayer1Name() {
        return player1.getPlayerName();
    }

    public String getPlayer2Name() {
        return player2.getPlayerName();
    }
}
