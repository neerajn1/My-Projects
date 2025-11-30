
public class Table {
    // Private parts that are retrieved with getters and setters
    private String material;
    private int length;
    private int width;
    private String make;
    private String model;
    private int year;

    // Constructor ('this' refers to the object Table itself)
    public Table() {
        this.material = "Wood";
        this.length = 5;
        this.width = 4;
        this.make = "Mini Vanity";
        this.model = "Exclusive";
        this.year = 2023;
    }

    // Parameters assigned to the object (Overloaded constructor)
    public Table(String material, int length, int width, String make, String model, int year) {
        this.material = material;
        this.length = length;
        this.width = width;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters for all the things that are private
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
