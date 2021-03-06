package game.gui.game;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import game.core.Game;
import game.core.GameLoop;
import game.core.Platform;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
                if (isButtonClicked) {
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

        platformLabel.setText("Platform - " + selectedGame.getPlatform());
        genreLabel.setText("Genre - " + selectedGame.getGenre());
        copiesSoldLabel.setText("Copies Sold - " + selectedGame.getCopiesSold());

        if (selectedGame.isOnMarket()) {
            marketStatusLabel.setText("On Market - Strength: " + selectedGame.getMarketMultiplier());
        } else {
            marketStatusLabel.setText("Off Market");
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        costLabel = new JLabel();
        costLabel.setText("Cost -");
        mainPanel.add(costLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        profitLabel = new JLabel();
        profitLabel.setText("Profit - ");
        mainPanel.add(profitLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ratingLabel = new JLabel();
        ratingLabel.setText("Rating -");
        mainPanel.add(ratingLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        platformLabel = new JLabel();
        platformLabel.setText("Platform -");
        mainPanel.add(platformLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genreLabel = new JLabel();
        genreLabel.setText("Genre -");
        mainPanel.add(genreLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        copiesSoldLabel = new JLabel();
        copiesSoldLabel.setText("Copies Sold - ");
        mainPanel.add(copiesSoldLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        marketStatusLabel = new JLabel();
        marketStatusLabel.setText("Market Status - ");
        mainPanel.add(marketStatusLabel, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        closeButton = new JButton();
        closeButton.setText("Close");
        mainPanel.add(closeButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteButton = new JButton();
        deleteButton.setBackground(new Color(-1250068));
        deleteButton.setForeground(new Color(-6282711));
        deleteButton.setText("Delete");
        mainPanel.add(deleteButton, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
