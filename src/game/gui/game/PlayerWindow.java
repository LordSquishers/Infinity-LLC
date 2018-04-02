package game.gui.game;

import game.core.GameLoop;

import javax.swing.*;
import java.awt.*;

/**
 * Window base template
 *
 * @author BrusselSprout
 **/
public class PlayerWindow extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(600, 500);

    public PlayerWindow() {
        super("Player - " + GameLoop.gameSave.getGameName());

        JPanel mainPanel = new PlayerUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
