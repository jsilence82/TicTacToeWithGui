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
        int pick;
        do {
            pick = random.nextInt(9) + 1;
        } while (this.board.spaceOccupied(pick));
        return pick;
    }

    @Override
    public void setBoard(Board board) {
         this.board = board;
    }
}
