//Banana subclass
class Banana extends Fruit {
    String shortOrLong; //added different string so each time, there's a chance for something new

    public Banana(String appearance, String ripe, String shortOrLong) {
        super(appearance, ripe);  // super() helps to inherit from superclass fruit
        this.shortOrLong = shortOrLong;
    }
    @Override
    public void getFruitData() {
        System.out.println("Banana data: ");
        super.getFruitData();  // Access method from the superclass
        System.out.println("Short/long: " + shortOrLong);
    }
}
