import java.util.*;

public class enhancedCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean proceed = true; //boolean to check if the whole calculator program should continue or not

        while (proceed) {
            int num1, num2;
            int result;
            char prompt;

            // Added hasNextInt to check for integer validity and made it more clear than the 1st one with .next to go further
            System.out.println("Enter two numbers (one number at a time, then press enter):");

            // For 1st number
            System.out.println("Enter first number: ");
            while (!input.hasNextInt()) {
                System.out.println("Wrong input...");
                input.next();
                System.out.println("Enter first number: ");
            }
            num1 = input.nextInt();

            // For 2nd number
            System.out.println("Enter second number: ");
            while (!input.hasNextInt()) {
                System.out.println("Wrong input...");
                input.next();
                System.out.print("Enter second number: ");
            }
            num2 = input.nextInt();

            // Same from 1st calculator
            System.out.println("Type in a for +, b for -, c for ÷, and d for *");
            prompt = input.next().charAt(0);

            if (prompt == 'a') {
                result = num1 + num2;
                System.out.println("The answer is: " + result);
            } else if (prompt == 'b') {
                result = num1 - num2;
                System.out.println("The answer is: " + result);
            } else if (prompt == 'c') {
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

            // Asking the user if they want to proceed again?
            System.out.println("Do you want to proceed again? (y/n)");
            char proceedPrompt = input.next().charAt(0);
            if (proceedPrompt != 'y') {
                proceed = false; //adding false here makes the program to stop since y isn't typed in
            }
        }

        // Added a finishing touch by totally closing the user's input...
        input.close();
        System.out.println("Thank you for using this tool.");
    }
}
