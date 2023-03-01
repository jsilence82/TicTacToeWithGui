package Model.players;

import Model.Board;

public class Factory {

    public static Player playerFactory(int entry, String playerName, String playersMark, Board board) {
        return switch (entry) {
         case 1 -> new HumanPlayer(playerName, playersMark);
         case 2 -> new Computer(board, playersMark);
         case 3 -> new AI(board, playersMark);
         default -> null;
        };
    }
}
