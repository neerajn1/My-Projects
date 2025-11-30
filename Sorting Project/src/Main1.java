import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        // Create an array of custom Dessert objects
        Dessert[] dessertList = {
                new Dessert("Chocolate Ice Cream", 143, 8),
                new Dessert("Salted Caramel Brownie", 580, 6),
                new Dessert("Vanilla Cupcake", 230, 4),
                new Dessert("Lemon Bite", 230, 6),
                new Dessert("Glazed Donut", 210, 5)
        };

        // Testing MergeSort with dessertList objects
        testSort("MergeSort - Dessert Array", dessertList, MergeSort::mergeSort);

        // Testing QuickSort with dessertList objects
        testSort("QuickSort - Dessert Array", dessertList, QuickSort::quickSort);

        // Testing HeapSort with dessertList objects
        HeapSort<Dessert> heapSort = new HeapSort<>();
        testSort("HeapSort - Dessert Array", dessertList, heapSort::heapSort);

        // Testing ShellSort with dessertList objects
        ShellSort<Dessert> shellSort = new ShellSort<>();
        testSort("ShellSort - Dessert Array", dessertList, (array) -> shellSort.shellSort(array, Comparable::compareTo)); //compare this object with specified object for order
    }

    // Checking for a generic sorting algorithm with Dessert array

    private static <T extends Comparable<T>> void testSort(String sortName, T[] array, SortFunction<T> sortFunction) {
        System.out.println(sortName + ":");
        System.out.println("Unordered Array (Before): " + Arrays.toString(array));
        sortFunction.sort(array);
        System.out.println("Sorted Array (After):   " + Arrays.toString(array));
        System.out.println("Is Sorted?:      " + isSorted(array));
        System.out.println();
    }

    // Checking if the array is sorted in ascending/correct order as per requirements

    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true; //return true otherwise if not false
    }

    // Functional interface for sorting functions which is needed utmost when using Comparable interface

    @FunctionalInterface
    private interface SortFunction<T extends Comparable<T>> {
        void sort(T[] array);
    }
}

