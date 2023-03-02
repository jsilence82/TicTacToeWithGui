package Model.players;

import Model.Board;

import java.util.Random;

public class Computer extends Player {

    Board board;
    private final Random random = new Random();

    Computer(Board board, String playersMark) {
        super("Random", playersMark, true);
        this.board = board;
        setPlayerMessage("The computer is randomly picking...");
    }

    @Override
    public int pickASpace() {
        int pick = random.nextInt(9) + 1;
        if (board.spaceOccupied(pick)) {
            return pickASpace();
        }
        return pick;
    }
}
