package game.core;

import java.util.HashMap;

public class GameSave {

    public static final float STARTING_AMT = 3000f;
    public static final float UPGRADE_CONVERSION = 3;

    private String gameName;
    private HashMap<String, String> gameProperties = new HashMap<>();

    public GameSave(String gameName, String companyName, String playerName, int playerArt, int playerProgramming) {
        this.gameName = gameName;
        setProperty("company_name", companyName);
        setProperty("player_name", playerName);
        setProperty("player_art", String.valueOf(playerArt));
        setProperty("player_programming", String.valueOf(playerProgramming));
        setProperty("company_money", String.valueOf(STARTING_AMT));
        setProperty("player_upgrade", String.valueOf(0));
    }

    public GameSave(String gameName, HashMap<String, String> gameProperties) {
        this.gameName = gameName;
        this.gameProperties = gameProperties;
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
