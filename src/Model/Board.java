package Model;

import java.util.HashMap;
import java.util.Objects;

public class Board {

    private HashMap<Integer, String> board;

    public Board() {
        initializeBoard();
    }

    public HashMap<Integer, String> getBoard() {
        return board;
    }

    private void initializeBoard() {
        board = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            board.put(i, String.valueOf(i));
        }
    }

    public void placePlayersMark(int playersPick, String playersMark) {
        board.put(playersPick, playersMark);
    }

    public boolean spaceOccupied(int playersPick) {
        return board.get(playersPick).equals("X") || board.get(playersPick).equals("O");
    }

    public boolean boardIsFull() {
        return board.values().stream().noneMatch("123456789"::contains);
    }

    public boolean checkWinner(String playersMark) {
        int[][] winningConditions = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8},
                {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
        for (int[] numbers : winningConditions) {
            if (Objects.equals(board.get(numbers[0]), board.get(numbers[1])) &&
                    Objects.equals(board.get(numbers[1]), board.get(numbers[2]))) {
                if (Objects.equals(board.get(numbers[0]), playersMark)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] mapToCoordinates(int space) {
        int[] coordinates = new int[2];
        coordinates[0] = (space - 1) / 3;
        coordinates[1] = (space - 1) % 3;
        return coordinates;
    }

    public int coordinatesToMap(int[] coordinates) {
        return coordinates[0] * 3 + coordinates[1] + 1;
    }
}
