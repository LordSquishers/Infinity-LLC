package game.core;

import game.gui.game.MainGameWindow;

import javax.swing.*;

public class GameLoop {

    public static GameSave gameSave;
    public static DefaultListModel mainConsoleLog;

    public GameLoop(GameSave save) {
        this.gameSave = save;
        this.mainConsoleLog = new DefaultListModel();
        gameSave.addGame(new Game("Testing LLC", gameSave.getProperty("company_name"), 0.85f, 1125, 230));
        gameSave.addGame(new Game("Don't Buy This Game", gameSave.getProperty("company_name"), 0.25f, 200, 330));
        new MainGameWindow();
    }

    public static void addChatMessage(String message) {
        mainConsoleLog.addElement(message);

        if(mainConsoleLog.getSize() > 25) {
            mainConsoleLog.removeElementAt(0);
        }
    }

}
