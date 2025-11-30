public class HeapSort<T extends Comparable<T>> {

    public void heapSort(T[] array) {
        int n = array.length;

        // Build the initial heap
        for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--) {
            reheap(array, rootIndex, n - 1);
        }

        // Extract elements from the heap one by one
        for (int lastIndex = n - 1; lastIndex > 0; lastIndex--) {
            // Swap the root (largest) with the last element
            swap(array, 0, lastIndex);
            // Reheapify the reduced heap
            reheap(array, 0, lastIndex - 1);
        }}

    private void reheap(T[] heap, int rootIndex, int lastIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];

        int leftChildIndex = 2 * rootIndex + 1;

        while (!done && leftChildIndex <= lastIndex) {
            int largerChildIndex = leftChildIndex;

            int rightChildIndex = leftChildIndex + 1;

            // Check if right child exists and is larger
            if (rightChildIndex <= lastIndex &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex;
            }

            // If the orphan is smaller than the larger child, promote the larger child
            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex + 1;
            } else {

                done = true;
            }}

        // Place the orphan in the correct location
        heap[rootIndex] = orphan;
    }


    private void swap(T[] array, int i, int j) {
        T temp = array[i];

        array[i] = array[j];

        array[j] = temp;
    }
}
