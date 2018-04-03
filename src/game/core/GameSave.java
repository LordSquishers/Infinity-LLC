package game.core;

import engine.io.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GameSave {

    public static float STARTING_AMT = 3000f;
    public static float UPGRADE_CONVERSION = 3;

    private String gameName;
    private HashMap<String, String> gameProperties = new HashMap<>();
    private List<Game> games = new ArrayList<>();

    //SEE PROPERTY_LIST.ifn FOR ALL PROPERTIES
    public GameSave(String gameName, String companyName, String playerName, int playerArt, int playerProgramming) {
        this.gameName = gameName;
        setProperty("company_name", companyName);
        setProperty("player_name", playerName);
        setProperty("player_art", String.valueOf(playerArt));
        setProperty("player_programming", String.valueOf(playerProgramming));

        initializeBaseProperties();
    }

    public GameSave(String gameName, HashMap<String, String> gameProperties) {
        this.gameName = gameName;
        this.gameProperties = gameProperties;

        initializeBaseProperties();
    }

    private void initializeBaseProperties() {
        List<String> lines = FileManager.readSpecialFile("infinity-data/PROPERTY_LIST.ifn");

        Iterator<String> it = lines.iterator();
        while(it.hasNext()) {
            String line = it.next();

            //ignore cases
            if(!line.startsWith("--") && !line.equals(" ") && !line.equals("") && line != null && line.contains("=")) {
                String[] pair = line.split("=");
                if(!gameProperties.containsKey(pair[0])) // no duplicates/overwrites
                    setProperty(pair[0], pair[1]);
            }
        }

    }

    public List<Game> getGames() {
        return this.games;
    }

    public void addGame(Game game) { this.games.add(game); }

    public void removeGame(Game game) { this.games.remove(game); }

    public HashMap<String, String> getGameProperties() {
        return gameProperties;
    }

    public String getProperty(String propertyName) {
        return gameProperties.get(propertyName);
    }

    public void setProperty(String propertyName, String property) {
        this.gameProperties.put(propertyName, property);
    }

    public String getGameName() {
        return gameName;
    }

}
