package game.gui.game;

import game.core.GameLoop;

import javax.swing.*;
import java.awt.*;


public class MainGameWindow extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(600,500);

    public MainGameWindow() {
        super("Infinity LLC - " + GameLoop.gameSave.getGameName());

        JPanel mainPanel = new MainGameUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
