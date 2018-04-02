package game.gui.menu;

import com.sun.tools.javac.comp.Check;
import game.core.InfinityGame;

import javax.swing.*;
import java.awt.*;

/**
 * Title screen window
 */
public class TitleWindow extends JFrame {

    private static final String TITLE_TITLE = InfinityGame.GAME_TITLE;
    private static final Dimension WINDOW_SIZE = new Dimension(400,500);

    public TitleWindow() {
        super(TITLE_TITLE);

        JPanel mainPanel = new TitleUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
        requestFocus();
    }

}
