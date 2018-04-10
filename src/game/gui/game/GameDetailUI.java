package game.gui.game;

import game.core.Game;
import game.core.GameLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDetailUI {
    public JPanel mainPanel;
    private JLabel costLabel;
    private JLabel profitLabel;
    private JLabel ratingLabel;
    private JLabel platformLabel;
    private JLabel genreLabel;
    private JLabel copiesSoldLabel;
    private JLabel marketStatusLabel;
    private JButton closeButton;
    private JButton deleteButton;

    private boolean isButtonClicked = false;
    private Game selectedGame;

    public GameDetailUI(GameDetailWindow currentWindow, Game game) {
        this.selectedGame = game;
        isButtonClicked = false;
        initLabels();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isButtonClicked) {
                    GameLoop.gameSave.removeGame(game);
                    currentWindow.dispose();
                } else {
                    isButtonClicked = true;
                    deleteButton.setText("Are you sure?");
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentWindow.dispose();
            }
        });
    }

    private void initLabels() {
        profitLabel.setForeground(Color.BLACK);
        costLabel.setText("Cost - £" + selectedGame.getLoss());

        float profit = selectedGame.getProfit();
        if (profit > -1) {
            profitLabel.setText("Profit: £" + profit);
        } else {
            profitLabel.setText("Profit: -£" + -profit);
            profitLabel.setForeground(Color.RED);
        }

        ratingLabel.setText("Rating: " + (selectedGame.getRating() * 10) + " / 10");
    }
}
