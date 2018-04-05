package game.gui.game;

import game.core.GameLoop;

import javax.swing.*;
import java.awt.*;

/**
 * Window base template
 *
 * @author BrusselSprout
 **/
public class UpgradeOfficeWindow extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(400, 500);

    public UpgradeOfficeWindow() {
        super("Upgrade Office - " + GameLoop.gameSave.getProperty("company_name"));

        JPanel mainPanel = new UpgradeOfficeUI(this).mainPanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
