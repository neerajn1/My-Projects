public class Triangle extends SimpleGeometricObject {
    //Add private members base and height
    private double base;
    private double height;

    // Constructors where's one default and one other is from SimpleGeometricObject
    public Triangle() {
    }

    //super calls the constructor of the super class SimpleGeometricObject and base,height is '.this' since not originally from superclass
    public Triangle(double base, double height, String color, boolean filled) {
        super(color, filled);
        this.base = base;
        this.height = height;
    }

    // Getters and setters where base and height is retrieved
    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    // Triangle area formula is returned
    public double getArea() {
        return 0.5 * base * height;
    }

    // Override the toString method defined in the superclass
    @Override
    public String toString() {
        return super.toString() + "\nbase: " + base + "\nheight: " + height;
    }
}

