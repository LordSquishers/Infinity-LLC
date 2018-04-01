package game.gui.wizard;


import javax.swing.*;
import java.awt.*;

/**
 * Title screen window
 */
public class NewGameWindow extends JFrame {

    private static final String TITLE_TITLE = "Create New Game";
    private static final Dimension WINDOW_SIZE = new Dimension(400,500);

    public NewGameWindow() {
        super(TITLE_TITLE);

        JPanel mainPanel = new NewGameUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
