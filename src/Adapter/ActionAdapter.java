package Adapter;

import Contoller.Controller;
import Exceptions.MoveStackEmptyException;
import View.GameBoardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionAdapter implements ActionListener {
    private final Controller controller;
    private final GameBoardView view;

    public ActionAdapter(Controller controller, GameBoardView view) {
        this.controller = controller;
        this.view = view;
    }

    private void resetAll() {
        view.resetGame();
        controller.resetGame();
    }

    public void actionPerformed(ActionEvent e) {
        if (view.isReset(e) && view.getGameRunning()) {
            if (view.displayConfirmationMessage("A game is currently running. Do you want to abandon the current game and start a new one?")) {
                resetAll();
            }
        } else if (view.isReset(e)) {
            resetAll();
        } else if (view.isExit(e)) {
            if (view.displayConfirmationMessage("Do you really want to exit?")) {
                System.exit(0);
            }
        } else if (view.isUndo(e)) {
            try {
                controller.undoMove();
            } catch (MoveStackEmptyException exception) {
                view.displayErrorMessage(exception.getMessage());
            }       
        } else {
            ArrayList<Integer> position = view.getPosition(e);
            controller.setRequest(position);
        }
    }
}

