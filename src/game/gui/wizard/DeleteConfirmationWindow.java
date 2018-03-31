package game.gui.wizard;

import javax.swing.*;
import java.awt.*;

/**
 * delete confirmation window
 */
public class DeleteConfirmationWindow extends JFrame {

    private static final String TITLE_TITLE = " ";
    private static final Dimension WINDOW_SIZE = new Dimension(300,200);

    public DeleteConfirmationWindow(String gameName) {
        super(TITLE_TITLE);

        JPanel mainPanel = new DeleteConfirmationUI(this, gameName).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
