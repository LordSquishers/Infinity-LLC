package game.core;

import game.gui.game.MainGameWindow;

import javax.swing.*;

public class GameLoop {

    public static GameSave gameSave;
    public static DefaultListModel mainConsoleLog;

    public GameLoop(GameSave save) {
        this.gameSave = save;
        this.mainConsoleLog = new DefaultListModel();
        new MainGameWindow();
    }

    public static void addChatMessage(String message) {
        mainConsoleLog.addElement(message);

        if(mainConsoleLog.getSize() > 25) {
            mainConsoleLog.removeElementAt(0);
        }
    }

}
