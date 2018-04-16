package game.core;

import java.util.List;

public class Game {

    private String name;
    private String owner;

    private float cost;

    private float rating;
    private float gain;
    private float loss;

    private float copiesSold;
    private float marketMultiplier;
    private boolean isOnMarket;

    private Platform platform;
    private Genre genre;

    public Game(String name, String owner, float cost) {
        this.name = name;
        this.owner = owner;
        this.cost = cost;
        this.loss = cost;
    }

    public Game(String name, String owner, float rating, float gain, float loss, float cost) {
        this.name = name;
        this.owner = owner;
        this.rating = rating;
        this.gain = gain;
        this.loss = loss + cost;
    }

    public Game(String name, String owner, float cost, float rating, float gain, float loss, float copiesSold, float marketMultiplier, boolean isOnMarket, Genre genre, Platform platform) {
        this.name = name;
        this.owner = owner;
        this.cost = cost;
        this.rating = rating;
        this.gain = gain;
        this.loss = loss;
        this.copiesSold = copiesSold;
        this.marketMultiplier = marketMultiplier;
        this.isOnMarket = isOnMarket;
        this.genre = genre;
        this.platform = platform;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(float copiesSold) {
        this.copiesSold = copiesSold;
    }

    public float getMarketMultiplier() {
        return marketMultiplier;
    }

    public void setMarketMultiplier(float marketMultiplier) {
        this.marketMultiplier = marketMultiplier;
    }

    public boolean isOnMarket() {
        return isOnMarket;
    }

    public void setOnMarket(boolean onMarket) {
        isOnMarket = onMarket;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public float getProfit() {
        return gain - loss;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public void setLoss(float loss) {
        this.loss = loss;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public float getRating() {
        return rating;
    }

    public float getGain() {
        return gain;
    }

    public float getLoss() {
        return loss;
    }
}
