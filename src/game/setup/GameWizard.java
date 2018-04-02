package game.setup;

import engine.data.DataManager;
import engine.io.FileManager;
import game.core.GameLoop;
import game.core.GameSave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manages setup and pregame stuffs
 */
public class GameWizard {

    public static final String MAIN_SAVE_EXT = "_00";
    public static final String GAME_LIST_PATH = "game_list"; //TODO- bug fix, make sure no one can make a game called game_list

    /**
     * Creates a new game save
     * @param gameName - Name of save
     * @param companyName - Name of company
     * @param playerName - Name of player
     * @param playerArt - amount of art skill
     * @param playerProgramming - amount of programming skill
     * @return GameSave used to start the game
     */
    public GameSave newGameSetup(String gameName, String companyName, String playerName, int playerArt, int playerProgramming) {
        //TODO- use this and create a game save file
        //Creates the game save
        GameSave newSave = new GameSave(gameName, companyName, playerName, playerArt, playerProgramming);

        //Saves the save to a file
        DataManager.saveGameToFile(newSave);
        List<String> gameListData = getGameList();
        gameListData.add(gameName);
        FileManager.writeToFile(GAME_LIST_PATH, gameListData, true);

        return newSave;
    }

    /**
     * Loads a save
     * @param saveName - Name of save
     * @return GameSave used to start the game.
     */
    public GameSave loadGame(String saveName) {
        return DataManager.loadGameFromFile(saveName);
    }

    /**
     * Starts the game with a given save
     * @param gameSave GameSave to use
     */
    public void startGame(GameSave gameSave) {
        //TODO- start the game
        GameLoop mainGameLoop = new GameLoop(gameSave);
    }

    public void saveGame(GameSave save) {
        DataManager.saveGameToFile(save);
    }

    /**
     * Returns contents of the game list
     * @return the contents of the game list
     */
    public List<String> getGameList() {
        return FileManager.readFile(GAME_LIST_PATH);
    }

    /**
     * Refreshes the game list with all existing games
     */
    public void refreshGameList() {
        List<String> gameList = getGameList();
        List<String> existingFiles = FileManager.listFilesForFolder("infinity-data/saves");

        //gets all existing games from the save folder
        List<String> existingGames = new ArrayList<>();
        for(String file: existingFiles) {
            if(!file.equals(GAME_LIST_PATH + ".ifn") || file.endsWith("_00.ifn")) {
                String gamename = file.substring(0, file.length() - 7);
                existingGames.add(gamename);
            }
        }

        //Ensures that no games are left out and there are no
        // games that don't exist.

         //no games left out
        Iterator<String> listIterator = existingGames.iterator();
        while(listIterator.hasNext()) {
            String game = listIterator.next();

            if(!gameList.contains(game)) {
                gameList.add(game);
            }
        }

        //no non-existent games
        Iterator<String> listIterator2 = gameList.iterator();
        while(listIterator2.hasNext()) {
            String game = listIterator2.next();

            if(!existingGames.contains(game)) {
                listIterator2.remove();
            }
        }

        FileManager.writeToFile(GAME_LIST_PATH, gameList, true);
    }

    /**
     * deletes the game.
     * @param gameName - name of game to be removed.
     */
    public void deleteGame(String gameName) {
        if(!FileManager.deleteFile(gameName + MAIN_SAVE_EXT)) {
            //prints the status
            System.err.println("File could not be deleted. Make sure the file name is correct or check permissions.");
        } else {
            //prints the status
            System.out.println(gameName + MAIN_SAVE_EXT + FileManager.DATA_FILE_EXT + " has been deleted. Removing from "
                    + GAME_LIST_PATH + FileManager.DATA_FILE_EXT + " ...");

            //creates a new list with all the games that still exist
            List<String> gameList = getGameList();

            //Removing the old game
            Iterator<String> it = gameList.iterator();
            while(it.hasNext()) {
                String game = it.next();
                if(game.equals(gameName)) it.remove();
            }

            //writes to the list
            FileManager.writeToFile(GAME_LIST_PATH, gameList, true);

            //prints status
            System.out.println(gameName + MAIN_SAVE_EXT + FileManager.DATA_FILE_EXT + " has been removed from "
                    + GAME_LIST_PATH + FileManager.DATA_FILE_EXT);
        }
    }

}
