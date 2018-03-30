package game.core;

import java.util.HashMap;

public class GameSave {

    private String gameName;
    private HashMap<String, String> gameProperties = new HashMap<>();

    public GameSave(String gameName, String companyName, String playerName, int playerArt, int playerProgramming) {
        this.gameName = gameName;
        setProperty("company_name", companyName);
        setProperty("player_name", playerName);
        setProperty("player_art", String.valueOf(playerArt));
        setProperty("player_programming", String.valueOf(playerProgramming));
    }

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
