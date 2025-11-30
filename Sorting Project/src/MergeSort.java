/**
 * MergeSort class
 * Modified by Fatou Balde
 * This version handles generic types implementing Comparable.
 */
public class MergeSort<T extends Comparable<T>> {
    /** The method for sorting the array */
    public static <T extends Comparable<T>> void mergeSort(T[] list) {
        if (list.length > 1) {
// Merge sort the first half
            T[] firstHalf = (T[]) new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);
// Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            T[] secondHalf = (T[]) new Comparable[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
// Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }
    /** Merge two sorted arrays */
    public static <T extends Comparable<T>> void merge(T[] list1, T[] list2, T[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }
        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }
}


