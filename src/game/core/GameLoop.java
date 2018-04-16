package game.core;

import game.gui.game.MainGameWindow;

import javax.swing.*;

public class GameLoop {

    public static GameSave gameSave;
    public static DefaultListModel mainConsoleLog;

    public GameLoop(GameSave save) {
        this.gameSave = save;
        this.mainConsoleLog = new DefaultListModel();
        Game test1 = new Game("Testing LLC", gameSave.getProperty("company_name"), 0.85f, 1125, 230, 30);
        test1.setGenre(Genre.SANDBOX);
        test1.setPlatform(Platform.SWEDE_PHONE_3);
        Game test2 = new Game("Don't Buy This Game", gameSave.getProperty("company_name"), 0.25f, 200, 330, 50);
        test2.setGenre(Genre.ACTION);
        test2.setPlatform(Platform.BBOX);

        gameSave.addGame(test1);
        gameSave.addGame(test2);
        new MainGameWindow();
    }

    public static void addChatMessage(String message) {
        mainConsoleLog.addElement(message);

        if(mainConsoleLog.getSize() > 25) {
            mainConsoleLog.removeElementAt(0);
        }
    }

}
