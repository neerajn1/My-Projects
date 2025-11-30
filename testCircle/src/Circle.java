import java .util.*;

/*
 * A simple Circle class
 */

public class Circle {

    //class members
    private double radius;
    private Date date;
    private String color;


    //constructors
    public Circle() {
        //defaults
        this.radius = 1;
        this.color = "Red";
        this.date = new Date();
    }

    public Circle(double radius) {
        this.radius = radius;
        this.date = new Date();
    }

    public Circle(double radius,
                  String color ) {
        this.radius = radius;
        this.date = new Date();
        this.color = color;
    }

    //getters and setters

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /* Print the circle info */
    public void printCircle() {
        System.out.println("The circle was created on " + date.toString() +
                " and the radius is " + radius);
    }
}
