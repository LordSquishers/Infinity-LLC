package game.gui.wizard;


import javax.swing.*;
import java.awt.*;

/**
 * Load screen window
 */
public class DeleteGameWindow extends JFrame {

    private static final String TITLE_TITLE = "Delete Save";
    private static final Dimension WINDOW_SIZE = new Dimension(400,500);

    public DeleteGameWindow() {
        super(TITLE_TITLE);

        JPanel mainPanel = new DeleteGameUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
