public class TestTriangle {
    public static void main(String[] args) {
        // Create a new triangle object instance
        Triangle t1 = new Triangle(10.0, 20.0, "green", true);

        // Output the inherited attributes using superclass methods from SimpleGeometricObject
        System.out.println("Inherited Attributes ↓");
        System.out.println("Color: " + t1.getColor());
        System.out.println("Filled: " + t1.isFilled());
        System.out.println("Date Created: " + t1.getDateCreated());

        // Setting our own custom base and height for triangle (decimal since double method)
        t1.setBase(15.0);
        t1.setHeight(20.0);

        // Display the area from what's been set and .toString displays the date, color, and filled from superclass
        System.out.println("\nTriangle Attributes:");
        System.out.println(t1.toString());
        System.out.println("Area: " + t1.getArea());
    }
}
