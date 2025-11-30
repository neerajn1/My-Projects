
import java.util.Random;
public class reverseArray {
    // Generating random numbers between 1-50
    public static void main(String[] args) {
        int [] mainArray = new int [10];
        Random rand = new Random();
        for (int i = 0; i < mainArray.length; i++) {
            mainArray[i] = rand.nextInt(50);
        }
        //Prints out main array
        System.out.print("Main Array: ");
        for (int numbers : mainArray) {
            System.out.print(numbers + " ");
        }
        System.out.println();

        //Another array is created to reverse the main array numbers into the new array output
        int[] reversingArray = reverse(mainArray);

        System.out.print("Reversed Array: ");
        for (int numbers : reversingArray) {
            System.out.print(numbers + " ");
        }
    }

    //Reversal method of the main array which outputs original numbers in reverse in the new array output
    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1;
             i < list.length; i++, j--) {
            result[j] = list[i];
        }

        return result;
        }
    }

