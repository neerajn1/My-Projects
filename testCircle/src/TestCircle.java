public class TestCircle {

    public static void main(String[] args) {
        // Create a Circle object of radius 1
        Circle circle1 = new Circle(1.0);

        // Create a second Circle object of radius 2
        Circle circle2 = new Circle(2.0);

        // Print the diameter of both circles
        System.out.println("Diameter of Circle 1: " + circle1.getDiameter());
        System.out.println("Diameter of Circle 2: " + circle2.getDiameter());

        // Exercise the printCircle method for both Circle objects
        System.out.println("Circle 1:");
        circle1.printCircle();

        System.out.println("Circle 2:");
        circle2.printCircle();
    }
}
