import java.util.*;

//Custom exception class invalid one is being inherited from exception the main superclass
class InvalidInputException extends Exception {
    public InvalidInputException(String except) {
        super(except);
    }
}

public class updatedCalculator {
    public static void main(String[] args) {
        int num1, num2, result;
        char prompt;
        Scanner input = new Scanner(System.in);

        try {
            //Getting the number input from the user
            System.out.println("enter two numbers (one number at a time then press enter)");
            num1 = input.nextInt();
            num2 = input.nextInt();

            numVariance(num1); //num1 and num2 both turn into "num" where in this method, the number variance is checked
            numVariance(num2);

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
        } catch (InvalidInputException ex) {
            System.out.println("Error dear user!... " + ex.getMessage());
        }
    }

    public static void numVariance(int num) throws InvalidInputException {
        if (num < 1 || num > 100) {
            throw new InvalidInputException("Your input " + num + " is out of the range from what this calculator can handle. Please input from 1-100 only.");
        }
    }
}