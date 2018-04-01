package game.gui.wizard;


import javax.swing.*;
import java.awt.*;

/**
 * Load screen window
 */
public class LoadGameWindow extends JFrame {

    private static final String TITLE_TITLE = "Load Save";
    private static final Dimension WINDOW_SIZE = new Dimension(400,500);

    public LoadGameWindow() {
        super(TITLE_TITLE);

        JPanel mainPanel = new LoadGameUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
