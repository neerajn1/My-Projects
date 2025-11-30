import java.util.Random;
//Default constructor
public class Food {

    private String name;

    private int calories;

    private static String[] randomFoods = {"Banana", "Dragon-fruit", "Raspberry", "Plum", "Orange", "Prawns", "Crab", "Lobster", "Chocolate Cake", "Oysters"};

    public Food() {

        this.name = getRandomFoods();

        this.calories = 0;

    }

//Overloaded constructor

    public Food(String name, int calories) {

        if (name == null) {

            this.name = getRandomFoods();

        } else {

            this.name = name;

        }

        this.calories = calories;

    }

//Getter and setters

    public int getCalories() {

        return calories;

    }

    public void setCalories(int calories) {

        this.calories = calories;

    }

    public String getName() {

        return name;

    }

//Supports retrieving something from the made list above using {}

    private String getRandomFoods() {

        Random rand = new Random();

        return randomFoods[rand.nextInt(randomFoods.length)];

    }

//Override toString method to support printArray method

    @Override

    public String toString() {

        return String.format("Food name: %-20s Its calories: %-5d", name, calories);

    }
}

