public class Main {
    public static void main(String[] args) {
        // Making a new Apple object from the Apple class
        Apple apple = new Apple("granny smith", "yes", "Michigan");
        apple.getFruitData(); //Now direct method printout via overridden method

        System.out.println("------------------------------");

        // Making a new Banana object from the Banana class
        Banana banana = new Banana("Bright yellow", "yes", "short");
        banana.getFruitData();

        //Polymorphism
        System.out.println("------------------------------");

        Fruit fresh = new Apple("Gala", "Yes", "Texas");
        Fruit nill = new Banana("Super green", "no", "long");

        System.out.println("New data from the fruit class itself without the main use of Apple or Banana: ");
        fresh.getFruitData();
        System.out.println("------------------------------");
        nill.getFruitData();
    }
}
