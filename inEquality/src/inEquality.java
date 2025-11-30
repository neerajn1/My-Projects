import java.util.*;

public class inEquality {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What's your age? : ");
        int userAge = input.nextInt();

        int eligibleAge = 18;

        if (userAge != eligibleAge) {
            if (userAge < eligibleAge) {
                System.out.println("Sorry, you're too young and not eligible to vote.");
            } else {
                System.out.println("Good, you're old enough and eligible to vote.");
            }
        } else {
            System.out.println("Congrats! You're now finally " + eligibleAge + " and now you can vote.");
        }

        input.close();
    }
}
