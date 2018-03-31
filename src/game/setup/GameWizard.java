package game.setup;

import engine.io.FileManager;
import game.core.GameSave;

import java.util.ArrayList;
import java.util.List;

public class GameWizard {

    public static String MAIN_SAVE_EXT = "_00";

    private List<GameSave> gameSaveList = new ArrayList<>();

    public void newGameSetup(String gameName, String companyName, String playerName, int playerArt, int playerProgramming) {
        //TODO- use this and create a game save file (then start it)
        GameSave newSave = new GameSave(gameName, companyName, playerName, playerArt, playerProgramming);
    }

    public GameSave loadGame() {
        //TODO- make code for loading a game
        return null;
    }

    public void deleteGame(String gameName) {
        if(!FileManager.deleteFile(gameName + MAIN_SAVE_EXT))
            System.err.println("File could not be deleted. Make sure the file name is correct or check permissions.");
    }

}
