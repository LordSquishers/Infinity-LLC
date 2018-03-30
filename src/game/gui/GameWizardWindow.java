package game.gui;

import game.core.InfinityGame;

import javax.swing.*;
import java.awt.*;

/**
 * Title screen window
 */
public class GameWizardWindow extends JFrame {

    private static final String TITLE_TITLE = " ";
    private static final Dimension WINDOW_SIZE = new Dimension(400,500);

    public GameWizardWindow() {
        super(TITLE_TITLE);

        JPanel mainPanel = new GameWizardUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
