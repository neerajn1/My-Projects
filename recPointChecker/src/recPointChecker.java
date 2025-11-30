import java.util.Scanner;

public class recPointChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a point with two coordinates (ex:- 4 2) :  ");
        double x = input.nextDouble();
        double y = input.nextDouble();

        // Width and height of the rectangle
        double rectangleWidth = 25;
        double rectangleHeight = 15;

        // Half width and height is needed for horizontal and vertical distance
        double halfWidth = rectangleWidth / 2;
        double halfHeight = rectangleHeight / 2;

        //Print formatting is used for easy rounding of decimal numbers
        if (Math.abs(x) <= halfWidth && Math.abs(y) <= halfHeight) {
            System.out.printf("Point (%.1f, %.1f) is in the rectangle.", x, y);
        } else {
            System.out.printf("Point (%.1f, %.1f) is not in the rectangle.", x, y);
        }
        //Close from running more input
        input.close();

    }
}
