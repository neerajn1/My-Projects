//Program: Food Tracker
// By: Neeraj N
// Section: 5
// Description: This program tracks food intake for health purposes.
// This is made up of superclass Food, 2 subclasses Dessert/Meat
//Uses arrays below shown for all 3 objects
//Everything's formatted well where % are format specifiers where the minus will help the text to align corrctly

public class foodTracker {
    public static void main(String[] args) {
        Food[] foodList = new Food[3];       //New objects created 3 for each super/subclass
        foodList[0] = new Food("Pear", 100);
        foodList[1] = new Food("Kiwi", 42);
        foodList[2] = new Food();
        foodList[2].setCalories(69);

        Dessert[] dessertList = new Dessert[3];
        dessertList[0] = new Dessert("Brownie Bites", 120, "Medium", false);
        dessertList[1] = new Dessert("Glazed Doughnut", 195, "High", true);
        dessertList[2] = new Dessert();

        Meat[] meatList = new Meat[3];
        meatList[0] = new Meat("Chicken Breasts", 110, "Poultry", true);
        meatList[1] = new Meat("Large Raw Shrimp", 70, "Seafood", false);
        meatList[2] = new Meat();

        System.out.println("Foods: ");
        printArray(foodList);

        System.out.println("\nDesserts: ");
        printArray(dessertList);

        System.out.println("\nMeat: ");
        printArray(meatList);
    }

    //printArray from the overrides made
    public static void printArray(Object[] array) {
        for (Object lis : array) {
            System.out.println(lis.toString());
        }
    }
}
