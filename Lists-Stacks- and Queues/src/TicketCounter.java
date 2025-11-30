// This TicketCounter code mainly maps out a store with customers and multiple cashiers in it.
// Arrival/departure times are the main key for the customers which is tracked in this program
// Total average time will be shown for the customer's shopping time with cashier availability syncing with it that can alter the results
// For queue customerQueue, it's basically a LinkedList as well where the line of customers is shown in print as Java code.

import java.util.*; // Import the Queue and LinkedList easily without having 2 imports and only one asterisk

// This is a ticket counter system where multiple cashiers serve the customers in this "queue"
public class TicketCounter {
    private final static int PROCESS = 120; // Amount of time
    private final static int MAX_CASHIERS = 10; // Number of cashiers present
    private final static int NUM_CUSTOMERS = 100; // Number of customers present

    public static void main(String[] args) {
        Customer customer;
        Queue<Customer> customerQueue = new LinkedList<Customer>(); // New queue starts from here to take control over customer's orders
        int[] cashierTime = new int[MAX_CASHIERS]; // Track's cashier's availability by time in this array
        int totalTime, averageTime, departs, start;

        // For loop for cashiers taking orders
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {
            // Time for cashiers set to zero before thei begin
            for (int count = 0; count <= cashiers; count++)
                cashierTime[count] = 0;

            // Customer queue starts from here where they arrive to the store every 15 seconds
            for (int count = 1; count <= NUM_CUSTOMERS; count++)
                customerQueue.add(new Customer(count * 15));

            totalTime = 0; // Time changed to the starting after each transaction is completed

            // All customers are handled here
            while (!(customerQueue.isEmpty())) {
                // For loop to see the availability of cashiers
                for (int count = 0; count <= cashiers; count++) {
                    if (!(customerQueue.isEmpty())) {
                        customer = customerQueue.remove(); // Customer is removed from the queue after their order is finished

                        // Time tracked for customer once they get a cashier to place their order
                        if (customer.getArrivalTime() > cashierTime[count])
                            start = customer.getArrivalTime(); // Check is the cashier is available after they arrive
                        else
                            start = cashierTime[count]; // Check is the cashier is available  before they arrive

                        // Departure time is placed upon the customer
                        departs = start + PROCESS;
                        customer.setDepartureTime(departs);
                        cashierTime[count] = departs; // Cashier's availability is updated here

                        // All the full time they've spent in the store is added here (customer)
                        totalTime += customer.totalTime();
                    }
                }
            }

            // Average time per customer is calculated here
            averageTime = totalTime / NUM_CUSTOMERS;
            System.out.println("Number of cashiers: " + (cashiers + 1));
            System.out.println("Average time: " + averageTime + "\n");
        }
    }
}

// Customer class is created here to set in place and track their arrival/departure time
class Customer {
    private int arrivalTime, departureTime;

    // Constructor for arrival/departure where the initial placer here is zero
    public Customer(int arrives) {
        arrivalTime = arrives;
        departureTime = 0;
    }

    // Getter for the arrival time of the customer
    public int getArrivalTime() {
        return arrivalTime;
    }

    // Setter for the departure time once the customer has entered the store
    public void setDepartureTime(int departs) {
        departureTime = departs;
    }

    // Customer's total in time is calculated
    public int totalTime() {
        return departureTime - arrivalTime;
    }
}
