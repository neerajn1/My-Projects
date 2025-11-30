import java.util.Random;

public class Meat extends Food {
    private String meatType;
    private boolean freshOrFrozen;
    private static String[] randomTypes = {"Red meat", "Poultry", "Seafood", "Variety Meats"};

    //Default
    public Meat() {
        super();
        this.meatType = getRandomTypes();
        this.freshOrFrozen = false;
    }

    //Overloaded
    public Meat(String name, int calories, String meatType, boolean freshOrFrozen) {
        super(name, calories);
        if (meatType == null) {
            this.meatType = getRandomTypes();
        } else {
            this.meatType = meatType;
        }
        this.freshOrFrozen = freshOrFrozen;
    }

    //Randomize
    private String getRandomTypes() {
        Random rand = new Random();
        return randomTypes[rand.nextInt(randomTypes.length)];
    }

    //Support printArray
    @Override
    public String toString() {
        String freshStatus;
        if (freshOrFrozen) {
            freshStatus = "Fresh";
        } else {
            freshStatus = "Frozen";
        }
        return String.format("%s  Meat Category: %-15s  Fresh/Frozen: %s", super.toString(), meatType, freshStatus);
    }
}
