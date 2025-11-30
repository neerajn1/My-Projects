import java.util.*;

public class Exception {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean proceed = true; // to start/end the game

        while (proceed) {
            try {
                System.out.print("Num 1: ");
                int num1 = input.nextInt();
                System.out.print("Num 2: ");
                int num2 = input.nextInt();
                //Java doesn't have auto exception for multiply by zer0, only for division so make new one ourselves
                if (num1 == 0 || num2 == 0) {
                    throw new ArithmeticException("No multiplication by zero!");
                }

                int answer = num1 * num2;
                System.out.println("Answer: " + answer);

                System.out.print("Operate again? (y/n) ");
                String option = input.next();

                if (option.equalsIgnoreCase("n")) {
                    proceed = false;
                }
            } catch (ArithmeticException ex) {
                System.out.println("Error since you typed zero!");
            }
        }
    }
}

