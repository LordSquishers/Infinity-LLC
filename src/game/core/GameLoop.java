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

}
