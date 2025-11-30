public class QuickSort {
    // Modified by: Charles W
    // Generic quickSort method that works with any type T implementing Comparable
    public static <T extends Comparable<T>> void quickSort(T[] list) { // Changed from int[] to T[] and added <T extends Comparable<T>>
        quickSort(list, 0, list.length - 1);
    }
    // Overloaded quickSort method with additional parameters for generic handling
    public static <T extends Comparable<T>> void quickSort(T[] list, int first, int last) { // Changed from int[] to T[] and added <T extends Comparable<T>>
        if (last > first) {
            int pivotIndex = partition(list, first, last); // Pivot handling remains the same, works generically now
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    /** Partition the array list[first..last] */
    public static <T extends Comparable<T>> int partition(T[] list, int first, int last) { // Changed from int[] to T[] and added <T extends Comparable<T>>
        T pivot = list[first]; // Changed type from int to T for generic handling
        int low = first + 1;   // Index for forward search
        int high = last;       // Index for backward search
        while (high > low) {
            // Search forward from left using compareTo for generic comparison
            while (low <= high && list[low].compareTo(pivot) <= 0) // Changed from list[low] <= pivot to list[low].compareTo(pivot) <= 0
                low++;
            // Search backward from right using compareTo for generic comparison
            while (low <= high && list[high].compareTo(pivot) > 0) // Changed from list[high] > pivot to list[high].compareTo(pivot) > 0
                high--;
            // Swap two elements in the list (if needed)
            if (high > low) {
                T temp = list[high]; // Changed type from int to T for generic handling
                list[high] = list[low];
                list[low] = temp;
            }
        }
        // Adjust high index to ensure pivot placement
        while (high > first && list[high].compareTo(pivot) >= 0) // Changed from list[high] >= pivot to list[high].compareTo(pivot) >= 0
            high--;
        // Swap pivot with list[high] to finalize partition
        if (pivot.compareTo(list[high]) > 0) { // Changed from pivot > list[high] to pivot.compareTo(list[high]) > 0
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}

