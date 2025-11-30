import java.util.Scanner;

public class futureInvestment {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate % ");
        double annualInterestRate = input.nextDouble();

        // Annual interest rate to monthly interest rate conversion (% to decimal)
        double monthlyInterestRate = annualInterestRate / 1200;

        System.out.print("Enter number of years: ");
        int numberOfYears = input.nextInt();

        // futureInvestmentValue math formula
        double futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);

        System.out.println("Accumulated value is " + futureInvestmentValue);

        // Close the input from system accepting more...
        input.close();
    }
}
