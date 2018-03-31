package game.gui.menu;

import game.core.InfinityGame;

import javax.swing.*;
import java.awt.*;

/**
 * Title screen window
 */
public class AboutWindow extends JFrame {

    private static final String TITLE_TITLE = "About " + InfinityGame.GAME_TITLE;
    private static final Dimension WINDOW_SIZE = new Dimension(400,500);

    public AboutWindow() {
        super(TITLE_TITLE);

        JPanel mainPanel = new AboutUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
