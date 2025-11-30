import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {

    public static void main(String[] args) {
        // Create an ArrayList for storing the items into the list
        ArrayList<String> ShoppingList = new ArrayList<>();

        // Form a scanner for user input
        Scanner input = new Scanner(System.in);

        // For loop since it's appropriate for a specific range of 10 and i+1 helps the user appear as item 1
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter item " + (i + 1 + " > "));
            String item = input.nextLine();
            ShoppingList.add(item);
        }

        // Print out the entire shopping list
        System.out.println("\nYour Shopping List:");
        for (String item : ShoppingList) {
            System.out.println("• " + item);
        }

        // Close the scanner
        input.close();
    }
}
