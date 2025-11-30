//Apple subclass
class Apple extends Fruit {
    String location;

    public Apple(String appearance, String ripe, String location) {
        super(appearance, ripe);  // super() helps to inherit from superclass fruit
        this.location = location;
    }
    @Override
    public void getFruitData() {
        System.out.println("Apple data: ");
        super.getFruitData();  // Access method from the superclass
        System.out.println("location: " + location);
    }
}


