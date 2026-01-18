package Model.players;

import Model.Board;

import java.util.Random;

public class Computer extends Player implements ComputerPlayer{

    Board board;
    private final Random random = new Random();

    Computer(String playersMark) {
        super("Random", playersMark);
        setIsComputer(true);
        setPlayerMessage("The computer is randomly picking...");
    }

    @Override
    public int pickASpace() {
        int pick = random.nextInt(9) + 1;
        if (this.board.spaceOccupied(pick)) {
            return pickASpace();
        }
        return pick;
    }

    @Override
    public void setBoard(Board board) {
         this.board = board;
    }
}
