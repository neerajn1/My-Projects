import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Arrays to test sorting algorithms
        Integer[] intObjArray = {29, 7, 65, 76, 8, 62};
        String[] stringArray = {"grapes", "oranges", "apples", "berries", "avocados"};

        // Testing MergeSort
        testSort("MergeSort - Integer Array", intObjArray, MergeSort::mergeSort); //2 : refer to calling method directly from the main subclass
        testSort("MergeSort - String Array", stringArray, MergeSort::mergeSort); //mergeSort extends from Comparable <T>

        // Testing QuickSort
        testSort("QuickSort - Integer Array", intObjArray, QuickSort::quickSort);
        testSort("QuickSort - String Array", stringArray, QuickSort::quickSort);

        // Testing ShellSort
        ShellSort<Integer> shellSortIntObj = new ShellSort<>();
        ShellSort<String> shellSortString = new ShellSort<>();
        testSort("ShellSort - Integer Array", intObjArray, (array) -> shellSortIntObj.shellSort(array, Comparator.naturalOrder()));
        testSort("ShellSort - String Array", stringArray, (array) -> shellSortString.shellSort(array, Comparator.naturalOrder())); // lambda expression for code conciseness and is required for functional/comparable interface

        // Testing HeapSort
        HeapSort<Integer> heapSortIntObj = new HeapSort<>();
        HeapSort<String> heapSortString = new HeapSort<>();
        testSort("HeapSort - Integer Array", intObjArray, heapSortIntObj::heapSort);
        testSort("HeapSort - String Array", stringArray, heapSortString::heapSort);
    }

    //Testing a generic sorting algorithm with a single type array
    private static <T extends Comparable<T>> void testSort(String sortName, T[] array, SortFunction<T> sortFunction) {
        System.out.println(sortName + ":");
        System.out.println("Unordered Array (Before): " + Arrays.toString(array));
        sortFunction.sort(array);
        System.out.println("Sorted Array (After):   " + Arrays.toString(array));
        System.out.println("Is Sorted?:      " + isSorted(array));
        System.out.println(); //for better formatting
    }

    //Checking the order of the array if it is sorted in ascending/correct order as required with for loop

    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true; //or else return true
    }

    //Functional interface for sorting functions as Comparator itself is this one

    @FunctionalInterface
    private interface SortFunction<T extends Comparable<T>> {
        void sort(T[] array);
    }
}

