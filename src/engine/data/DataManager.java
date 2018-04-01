package engine.data;

import engine.io.FileManager;
import game.core.GameSave;
import game.setup.GameWizard;

import java.util.*;

public class DataManager {

    /**
     * Saves the game data to a save file.
     * @param game - Game to save
     */
    public static void saveGameToFile(GameSave game) {
        String gameName = game.getGameName();
        HashMap<String, String> gameProperties = game.getGameProperties();

        //converts hashmap to key=value list
        List<String> fileOutput = new ArrayList<>();
        Iterator it = gameProperties.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            fileOutput.add(pair.getKey() + "=" + pair.getValue());
        }

        FileManager.writeToFile(gameName + GameWizard.MAIN_SAVE_EXT, fileOutput, true);
    }

    /**
     * Loads game data from a save file.
     * @param gamename - Game name
     * @return - Save data
     */
    public static GameSave loadGameFromFile(String gamename) {
        List<String> rawData = FileManager.readFile(gamename + "_00");
        HashMap<String, String> gameProperties = new HashMap<>();

        //converts file into map
        for(String entry: rawData) {
            String[] pair = entry.split("=");
            gameProperties.put(pair[0], pair[1]);
        }

        return new GameSave(gamename, gameProperties);
    }

}
