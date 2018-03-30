package game.core;

import game.gui.TitleWindow;
import game.setup.GameWizard;

public class InfinityGame {

    public static final String GAME_TITLE = "Infinity LLC";

    public static GameWizard gameWizard;

    public static void main(String[] args) {
        gameWizard = new GameWizard();

        TitleWindow titleScreen = new TitleWindow();
    }

}
