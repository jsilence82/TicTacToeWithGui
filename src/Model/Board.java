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
        switch (space) {
            case 1:
                break;
            case 2:
                coordinates[1] = 1;
                break;
            case 3:
                coordinates[1] = 2;
                break;
            case 4:
                coordinates[0] = 1;
                break;
            case 5:
                coordinates[0] = 1;
                coordinates[1] = 1;
                break;
            case 6:
                coordinates[0] = 1;
                coordinates[1] = 2;
                break;
            case 7:
                coordinates[0] = 2;
                break;
            case 8:
                coordinates[0] = 2;
                coordinates[1] = 1;
                break;
            case 9:
                coordinates[0] = 2;
                coordinates[1] = 2;
                break;
        }
        return coordinates;
    }

    public int coordinatesToMap(int[] coordinates) {
        int mapPoint = 0;
        int x = coordinates[0];
        int y = coordinates[1];

        if (x == 0 && y == 0) {
            mapPoint = 1;
        } else if (x == 0 && y == 1) {
            mapPoint = 2;
        } else if (x == 0 && y == 2) {
            mapPoint = 3;
        } else if (x == 1 && y == 0) {
            mapPoint = 4;
        } else if (x == 1 && y == 1) {
            mapPoint = 5;
        } else if (x == 1 && y == 2) {
            mapPoint = 6;
        } else if (x == 2 && y == 0) {
            mapPoint = 7;
        } else if (x == 2 && y == 1) {
            mapPoint = 8;
        } else if (x == 2 && y == 2) {
            mapPoint = 9;
        }
        return mapPoint;
    }
}
