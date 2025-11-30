public class Dessert extends Food implements Comparable<Dessert> {
    private int sweetnessLevel; // The sweetness level of the dessert

    // Constructor
    public Dessert(String name, int calories, int sweetnessLevel) {
        super(name, calories);
        this.sweetnessLevel = sweetnessLevel;
    }

    // Getter and Setter
    public int getSweetnessLevel() {
        return sweetnessLevel;
    }

    public void setSweetnessLevel(int sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }

    // Comparing desserts based on sweetness levels
    @Override
    public int compareTo(Dessert other) {
        return Integer.compare(this.sweetnessLevel, other.sweetnessLevel);
    }

    @Override
    public String toString() {
        return String.format(
                "Dessert{name='%s', calories=%d, sweetnessLevel=%d}",
                getName(), getCalories(), sweetnessLevel
        );
    }
}
