package game.gui.game;

import game.core.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Window base template
 *
 * @author BrusselSprout
 **/
public class GameDetailWindow extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(400, 500);

    public GameDetailWindow(Game selectedGame) {
        super(selectedGame.getName() + " - Details");

        JPanel mainPanel = new GameDetailUI(this, selectedGame).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
