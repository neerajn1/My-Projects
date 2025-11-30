import java.util.*;

public class ShellSort<T> { // Generic class with type parameter T

    // Rearrange elements at each n/2, n/4, n/8, ... intervals
    void shellSort(T[] array, Comparator<T> comparator) { // Changed this method to have generic array and comparator
        int n = array.length; // Added new int n to understand the array size when it changes frequently
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                T temp = array[i]; // Changed the type from int to S
                int j;
                for (j = i; j >= interval && comparator.compare(array[j - interval], temp) > 0; j -= interval) {
                    array[j] = array[j - interval]; //added a comparator to compare the array's continuous change
                }
                array[j] = temp;
            }
        }
    }
}
