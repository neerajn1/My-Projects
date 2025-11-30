import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        int num1, num2, result;
        char prompt;
        Scanner input = new Scanner(System.in);

        //Getting the number input from the user
        System.out.println("enter two numbers (one number at a time then press enter)");
        num1 = input.nextInt();
        num2 = input.nextInt();

        //Showing the main 4 operations to execute the calculation
        System.out.println("Type in a for +, b for -, c for ÷, and d for *");
        prompt = input.next().charAt(0);

        //If-else loops to perform the user's chosen operation by their letter prompt
        if (prompt == 'a') {
            result = num1 + num2;
            System.out.println("The answer is: " + result);
        } else if (prompt == 'b') {
            result = num1 - num2;
            System.out.println("The answer is: " + result);
        } else if (prompt == 'c') {
            //if user enters 0 in division, the user will be reminded of the 0 being invalid for division
            if (num2 != 0) {
                result = num1 / num2;
                System.out.println("The answer is: " + result);
            } else {
                System.out.println("No division by zero");
            }
        } else if (prompt == 'd') {
            result = num1 * num2;
            System.out.println("The answer is: " + result);
        } else {
            System.out.println("Wrong key");
        }
    }
}