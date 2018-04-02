package game.gui.game;

import game.core.GameLoop;

import javax.swing.*;
import java.awt.*;


public class MenuWindow extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(400,600);

    public MenuWindow() {
        super("Menu - " + GameLoop.gameSave.getGameName());

        JPanel mainPanel = new MenuUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
