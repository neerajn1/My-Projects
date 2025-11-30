import java.util.Stack; //needed for Stacks

public class stackClass {
    public static void main(String[] args) {
        // A new empty "numStack" is created here
        Stack<Integer> numStack = new Stack<>();

        // Push elements onto the numStack (i.e. adding them into this empty set)
        System.out.println("These following elements are pushed into this stack:");
        numStack.push(5);
        numStack.push(10);
        numStack.push(15);
        numStack.push(20);

        System.out.println("The final stack: " + numStack);

        // Peeking the 4th element in the stack (peek always chooses the last one in the list)
        System.out.println("One being peeked now: " + numStack.peek());

        // Numbers being popped (removed) from this following stack using a while loop
        System.out.println("Popping numbers number by number from the end of the list:");
        while (!numStack.isEmpty()) {
            System.out.println("\nPopped this: " + numStack.pop()); // \n creates a new line for spacing and better formatting
            System.out.println("\nStack currently: " + numStack);
        }

        // Verifying if the stack is empty based on this condition below
        System.out.println("\nIs the stack empty? " + numStack.isEmpty());
    }
}

