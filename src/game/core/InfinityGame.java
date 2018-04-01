package game.core;

import game.gui.menu.TitleWindow;
import game.setup.GameWizard;

import java.awt.*;

public class InfinityGame {

    public static final String GAME_TITLE = "Infinity LLC";

    public static GameWizard gameWizard;

    public static void main(String[] args) {
        gameWizard = new GameWizard();
        gameWizard.refreshGameList();

        TitleWindow titleScreen = new TitleWindow();
    }

}
