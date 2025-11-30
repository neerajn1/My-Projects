import java.util.Random;

public class Dessert extends Food {
    private String sweetLevel;
    private boolean stockAvail;
    private static String[] randomLevel = {"Low", "Medium", "High"};

    //Default
    public Dessert() {
        super();
        this.sweetLevel = getRandomLevel();
        this.stockAvail = false;
    }

    //Overloaded
    public Dessert(String name, int calories, String sweetLevel, boolean stockAvail) {
        super(name, calories);
        if (sweetLevel == null) {
            this.sweetLevel = getRandomLevel();
        } else {
            this.sweetLevel = sweetLevel;
        }
        this.stockAvail = stockAvail;
    }

    //Randomize
    private String getRandomLevel() {
        Random rand = new Random();
        return randomLevel[rand.nextInt(randomLevel.length)];
    }

    //Support printArray
    @Override
    public String toString() {
        String status;
        if (stockAvail) {
            status = "Available";
        } else {
            status = "Not available";
        }
        return String.format("%1s  Dessert sweetness: %-7s  Stock availability: %s", super.toString(), sweetLevel, status);
    }
}
