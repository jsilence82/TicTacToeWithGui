package Adapter;

import Contoller.Controller;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Adapter implements ActionListener {
    private final Controller controller;
    private final View view;

    public Adapter(Controller c, View v) {
        this.controller = c;
        this.view = v;
    }

    private void resetAll() {
        view.resetGame();
        controller.resetGame();
    }

    public void actionPerformed(ActionEvent e) {
        if (view.isReset(e) && view.getGameRunning()) {
            if (abandonGameConfirm()) {
                resetAll();
            }
        } else if (view.isReset(e)) {
            resetAll();
        } else if (view.isExit(e)) {
            if (exitProgramConfirm()) {
                System.exit(0);
            }
        } else if (view.isUndo(e)) {
            controller.undoMove();
        } else {
            ArrayList<Integer> position = view.getPosition(e);
            controller.setRequest(position);
        }
    }

    private boolean abandonGameConfirm() {
        int choice = JOptionPane.showConfirmDialog(null, "Game is running. Do you really want to abandon?",
                "Abandon Game", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }

    private boolean exitProgramConfirm() {
        int choice = JOptionPane.showConfirmDialog(null, "Do you really want to exit?",
                "Exit Game", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }
}

