import java.util.Scanner;

public class convertMoney {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // for loop to convert $ --> € thar runs exactly 3 times the same process
        for (int i = 0; i < 3; i++) {
            System.out.print("Type amount in $ to get the converted result in € (Euros) > ");
            double dollars = input.nextDouble();
            double euros = convertToEuro(dollars);
            System.out.println("$" + dollars + " = " + euros + " €");
        }

        // while loop to convert € --> $ with break added if -1 entered by user (runs until -1 is entered)
        System.out.println("Type amount in € to get the converted result in $ (Dollars) > ");
        while (true) {
            System.out.print("Enter an amount in Euros: ");
            double euros = input.nextDouble();
            if (euros == -1) {
                break;
            }
            double dollars = convertToDollar(euros);
            System.out.println(euros + " € = $" + dollars);
        }
        // close input from overriding the project
        input.close();
    }
    // methods that help to convert from one to another currency by multiplication as per the given rate
    public static double convertToEuro(double dollars) {
        return dollars * 0.94;
    }
    public static double convertToDollar(double euros) {
        return euros * 1.06;
    }
}
