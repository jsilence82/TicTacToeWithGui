package View;

import Adapter.Adapter;
import Contoller.Controller;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class View extends JFrame {

    private final JFrame gameWindow;
    private final JButton[][] spaces;
    private final JButton reset;
    private final JButton exit;
    public final JLabel playerTurnLabel;
    public final JLabel playerXLabel;
    public final JLabel playerOLabel;
    private final JButton undo;
    private boolean gameRunning;

    public View() {
        this.gameWindow = new JFrame("Tic Tac Toe");
        this.spaces = new JButton[3][3];
        this.reset = new JButton("New Game");
        this.exit = new JButton("Exit");
        this.playerTurnLabel = new JLabel();
        this.playerXLabel = new JLabel();
        this.playerOLabel = new JLabel();
        this.gameRunning = false;
        this.undo = new JButton("Undo");
        initialize();
    }

    public void setController(Controller controller) {
        new SelectionScreen(controller);
        setActionListener(controller);
    }

    public void initialize() {
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(new Dimension(400, 400));
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3, 3));
        gamePanel.add(game, BorderLayout.CENTER);
        JPanel options = new JPanel(new FlowLayout());
        options.add(undo);
        options.add(reset);
        options.add(exit);
        JPanel messages = new JPanel(new BorderLayout());
        playerTurnLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
        playerTurnLabel.setHorizontalAlignment(JLabel.CENTER);
        playerXLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
        playerXLabel.setHorizontalAlignment(JLabel.CENTER);
        playerOLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
        playerOLabel.setHorizontalAlignment(JLabel.CENTER);
        messages.setBackground(Color.white);
        gameWindow.add(messages, BorderLayout.NORTH);
        gameWindow.add(gamePanel, BorderLayout.CENTER);
        gameWindow.add(options, BorderLayout.SOUTH);

        messages.add(playerTurnLabel, BorderLayout.NORTH);
        messages.add(playerXLabel, BorderLayout.CENTER);
        messages.add(playerOLabel, BorderLayout.SOUTH);
        playerTurnLabel.setText("Welcome to Tic Tac Toe!");

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                spaces[row][column] = new JButton();
                spaces[row][column].setPreferredSize(new Dimension(75, 75));
                spaces[row][column].setFont(new Font("Ink Free", Font.BOLD, 50));
                spaces[row][column].setText("");
                game.add(spaces[row][column]);
            }
        }
        gameWindow.setVisible(true);
    }

    public void setActionListener(Controller controller) {
        Adapter adapter = new Adapter(controller, this);
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                spaces[row][column].addActionListener(adapter);
            }
        }
        reset.addActionListener(adapter);
        undo.addActionListener(adapter);
        exit.addActionListener(adapter);
    }

    public boolean isReset(ActionEvent e) {
        return e.getSource() == reset;
    }

    public boolean isExit(ActionEvent e) {
        return e.getSource() == exit;
    }

    public boolean isUndo(ActionEvent e) {
        return e.getSource() == undo;
    }

    public ArrayList<Integer> getPosition(ActionEvent e) {
        ArrayList<Integer> position = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (e.getSource() == spaces[row][column]) {
                    position.add(row);
                    position.add(column);
                }
            }
        }
        return position;
    }

    public void update(int row, int column, String symbol) {
        spaces[row][column].setText(symbol);
        spaces[row][column].setEnabled(false);
    }

    public void gameIsOver() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                spaces[i][j].setEnabled(false);
            }
        }
        setGameRunning(false);
    }


    public void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                spaces[row][column].setText("");
                spaces[row][column].setEnabled(true);
            }
        }
        playerTurnLabel.setText("Welcome to Tic Tac Toe!");
    }

    public void undoLastTurn(int[] lastTurn) {
        spaces[lastTurn[0]][lastTurn[1]].setText("");
        spaces[lastTurn[0]][lastTurn[1]].setEnabled(true);
    }

    public void setGameRunning(boolean b) {
        this.gameRunning = b;
    }

    public boolean getGameRunning() {
        return gameRunning;
    }

}