public class BicycleDemo {
    public static void main(String[] args) {
        // 2 Bicycle objects one with no arg(default) and with arguments(customization to default values)
        Bicycle b1 = new Bicycle();
        Bicycle b2 = new Bicycle(5, 3);

        // Mutator/setter methods to set the speed and gear of b1
        b1.setGear(2);
        b1.setSpeed(20);

        // Mutator/setter methods to set the speed and gear of b2
        b2.setGear(4);
        b2.setSpeed(15);

        // Get gear and speed of b1 and print (from getter method)
        System.out.println("B1 Gear: " + b1.getGear() + ", Speed: " + b1.getSpeed());

        // get gear and speed of b2 and print (from getter method)
        System.out.println("B2 Gear: " + b2.getGear() + ", Speed: " + b2.getSpeed());

        // Attempt to access members directly from demo program. What happens?
        // b1.speed = 37; // It'll cause an error since there's a private int value given to the speed which won't make it possible
        // Same thing with printing it out too which won't compile unless private turns into public
        // Encapsulation...
    }
}
