package game.core;

public class Game {

    private String name;
    private String owner;
    private float rating;
    private float gain;
    private float loss;

    //private List<Platform> releasedPlatforms;
    //private Genre genre;

    public Game(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public Game(String name, String owner, float rating, float gain, float loss) {
        this.name = name;
        this.owner = owner;
        this.rating = rating;
        this.gain = gain;
        this.loss = loss;
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
