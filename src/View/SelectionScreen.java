package View;

import Contoller.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectionScreen extends JFrame {

    private final JTextField player1Name;
    private final JTextField player2Name;

    public SelectionScreen(Controller controller) {
        setTitle("New Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel Title = new JPanel();
        contentPane.add(Title, BorderLayout.NORTH);
        Title.setLayout(new BorderLayout(0, 0));

        JLabel titleLabel = new JLabel("Player Select");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        Title.add(titleLabel);

        Component verticalStrut = Box.createVerticalStrut(20);
        Title.add(verticalStrut, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JTabbedPane player1Pane = new JTabbedPane(JTabbedPane.TOP);
        player1Pane.setToolTipText("Player 1");
        centerPanel.add(player1Pane);

        JPanel player1Select = new JPanel();
        player1Pane.addTab("Player 1", null, player1Select, null);
        GridBagLayout gbl_player1Select = new GridBagLayout();
        gbl_player1Select.columnWidths = new int[]{92, 86, 0};
        gbl_player1Select.rowHeights = new int[]{28, 23, 23, 0, 0};
        gbl_player1Select.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_player1Select.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        player1Select.setLayout(gbl_player1Select);

        JLabel player1Label = new JLabel("Player's Name");
        GridBagConstraints gbc_player1Label = new GridBagConstraints();
        gbc_player1Label.insets = new Insets(0, 0, 5, 5);
        gbc_player1Label.gridx = 0;
        gbc_player1Label.gridy = 0;
        player1Select.add(player1Label, gbc_player1Label);

        player1Name = new JTextField();
        player1Name.setEnabled(false);
        player1Name.setColumns(10);
        GridBagConstraints gbc_player1Name = new GridBagConstraints();
        gbc_player1Name.anchor = GridBagConstraints.NORTHWEST;
        gbc_player1Name.insets = new Insets(0, 0, 5, 0);
        gbc_player1Name.gridx = 1;
        gbc_player1Name.gridy = 0;
        player1Select.add(player1Name, gbc_player1Name);

        JRadioButton humanButton1 = new JRadioButton("Human Player");
        ItemListener player1FieldListener = e -> player1Name.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
        humanButton1.addItemListener(player1FieldListener);
        humanButton1.setActionCommand("1");
        ButtonGroup buttonGroupPlayer1 = new ButtonGroup();
        buttonGroupPlayer1.add(humanButton1);
        GridBagConstraints gbc_humanButton1 = new GridBagConstraints();
        gbc_humanButton1.anchor = GridBagConstraints.NORTHWEST;
        gbc_humanButton1.insets = new Insets(0, 0, 5, 5);
        gbc_humanButton1.gridx = 0;
        gbc_humanButton1.gridy = 1;
        player1Select.add(humanButton1, gbc_humanButton1);

        JRadioButton computerButton1 = new JRadioButton("Random (Easy)");
        computerButton1.setActionCommand("2");
        buttonGroupPlayer1.add(computerButton1);
        GridBagConstraints gbc_computerButton1 = new GridBagConstraints();
        gbc_computerButton1.gridwidth = 2;
        gbc_computerButton1.insets = new Insets(0, 0, 5, 0);
        gbc_computerButton1.anchor = GridBagConstraints.NORTHWEST;
        gbc_computerButton1.gridx = 0;
        gbc_computerButton1.gridy = 2;
        player1Select.add(computerButton1, gbc_computerButton1);

        JRadioButton aiButton1 = new JRadioButton("AI (Impossible)");
        aiButton1.setActionCommand("3");
        buttonGroupPlayer1.add(aiButton1);
        GridBagConstraints gbc_aiButton1 = new GridBagConstraints();
        gbc_aiButton1.insets = new Insets(0, 0, 0, 5);
        gbc_aiButton1.gridx = 0;
        gbc_aiButton1.gridy = 3;
        player1Select.add(aiButton1, gbc_aiButton1);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        centerPanel.add(horizontalStrut);

        JTabbedPane player2Pane = new JTabbedPane(JTabbedPane.TOP);
        player2Pane.setToolTipText("Player 2");
        centerPanel.add(player2Pane);

        JPanel player2Select = new JPanel();
        player2Pane.addTab("Player 2", null, player2Select, null);
        GridBagLayout gbl_player2Select = new GridBagLayout();
        gbl_player2Select.columnWidths = new int[]{92, 0, 0};
        gbl_player2Select.rowHeights = new int[]{14, 23, 0, 0, 0};
        gbl_player2Select.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_player2Select.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        player2Select.setLayout(gbl_player2Select);

        JLabel player2Label = new JLabel("Player's Name");
        GridBagConstraints gbc_player2Label = new GridBagConstraints();
        gbc_player2Label.insets = new Insets(0, 0, 5, 5);
        gbc_player2Label.gridx = 0;
        gbc_player2Label.gridy = 0;
        player2Select.add(player2Label, gbc_player2Label);

        player2Name = new JTextField();
        player2Name.setEnabled(false);
        GridBagConstraints gbc_player2Name = new GridBagConstraints();
        gbc_player2Name.insets = new Insets(0, 0, 5, 0);
        gbc_player2Name.fill = GridBagConstraints.HORIZONTAL;
        gbc_player2Name.gridx = 1;
        gbc_player2Name.gridy = 0;
        player2Select.add(player2Name, gbc_player2Name);
        player2Name.setColumns(10);

        JRadioButton humanButton2 = new JRadioButton("Human Player");
        ItemListener player2Listener = e -> player2Name.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
        humanButton2.setActionCommand("1");
        humanButton2.addItemListener(player2Listener);
        ButtonGroup buttonGroupPlayer2 = new ButtonGroup();
        buttonGroupPlayer2.add(humanButton2);
        GridBagConstraints gbc_humanButton2 = new GridBagConstraints();
        gbc_humanButton2.insets = new Insets(0, 0, 5, 5);
        gbc_humanButton2.anchor = GridBagConstraints.NORTHWEST;
        gbc_humanButton2.gridx = 0;
        gbc_humanButton2.gridy = 1;
        player2Select.add(humanButton2, gbc_humanButton2);

        JRadioButton computerButton2 = new JRadioButton("Random (Easy)");
        computerButton2.setActionCommand("2");
        buttonGroupPlayer2.add(computerButton2);
        GridBagConstraints gbc_computerButton2 = new GridBagConstraints();
        gbc_computerButton2.insets = new Insets(0, 0, 5, 5);
        gbc_computerButton2.gridx = 0;
        gbc_computerButton2.gridy = 2;
        player2Select.add(computerButton2, gbc_computerButton2);

        JRadioButton aiButton2 = new JRadioButton("AI (Impossible)");
        aiButton2.setActionCommand("3");
        buttonGroupPlayer2.add(aiButton2);
        GridBagConstraints gbc_aiButton2 = new GridBagConstraints();
        gbc_aiButton2.insets = new Insets(0, 0, 0, 5);
        gbc_aiButton2.gridx = 0;
        gbc_aiButton2.gridy = 3;
        player2Select.add(aiButton2, gbc_aiButton2);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new BorderLayout(0, 0));

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> {
            try {
                String player1Selection = buttonGroupPlayer1.getSelection().getActionCommand();
                String player2Selection = buttonGroupPlayer2.getSelection().getActionCommand();
                controller.startNewGame(player1Name.getText(), player2Name.getText(), Integer.parseInt(player1Selection), Integer.parseInt(player2Selection));
                SelectionScreen.this.dispose();
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Please select your players", "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        buttonPanel.add(startGameButton, BorderLayout.EAST);
        setVisible(true);
    }
}

