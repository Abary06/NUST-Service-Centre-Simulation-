package experiment;

import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;

public class SortingExperiment {
    public static void runExperiment() {
        int[] sizes = {20, 50, 100, 500};
        System.out.println("Sorting experiment results");
        System.out.println("Algorithm | Input Size | Comparisons | Time (ns)");

        for (int size : sizes) {
            int[] original = generateAscending(size);
            int[] selectionCopy = copyArray(original);
            int[] insertionCopy = copyArray(original);
            int[] mergeCopy = copyArray(original);
            int[] quickCopy = copyArray(original);

            long start = System.nanoTime();
            int selectionComparisons = SelectionSort.selectionSort(selectionCopy);
            long selectionTime = System.nanoTime() - start;
            System.out.println("Selection Sort | " + size + " | " + selectionComparisons + " | " + selectionTime);

            start = System.nanoTime();
            int insertionComparisons = InsertionSort.insertionSort(insertionCopy);
            long insertionTime = System.nanoTime() - start;
            System.out.println("Insertion Sort | " + size + " | " + insertionComparisons + " | " + insertionTime);

            start = System.nanoTime();
            int mergeComparisons = MergeSort.mergeSort(mergeCopy);
            long mergeTime = System.nanoTime() - start;
            System.out.println("Merge Sort | " + size + " | " + mergeComparisons + " | " + mergeTime);

            start = System.nanoTime();
            int quickComparisons = QuickSort.quickSort(quickCopy);
            long quickTime = System.nanoTime() - start;
            System.out.println("Quick Sort | " + size + " | " + quickComparisons + " | " + quickTime);
        }

        System.out.println("\nAlmost-sorted experiment");
        int[] almostSorted = generateAscending(100);
        swapAdjacentPairs(almostSorted, 5);
        int[] selectionAlmost = copyArray(almostSorted);
        int[] insertionAlmost = copyArray(almostSorted);
        int[] mergeAlmost = copyArray(almostSorted);
        int[] quickAlmost = copyArray(almostSorted);

        long start = System.nanoTime();
        int selComp = SelectionSort.selectionSort(selectionAlmost);
        long selTime = System.nanoTime() - start;
        System.out.println("Selection Sort almost-sorted | " + selComp + " | " + selTime);

        start = System.nanoTime();
        int insComp = InsertionSort.insertionSort(insertionAlmost);
        long insTime = System.nanoTime() - start;
        System.out.println("Insertion Sort almost-sorted | " + insComp + " | " + insTime);

        start = System.nanoTime();
        int mergeComp = MergeSort.mergeSort(mergeAlmost);
        long mergeTime = System.nanoTime() - start;
        System.out.println("Merge Sort almost-sorted | " + mergeComp + " | " + mergeTime);

        start = System.nanoTime();
        int quickComp = QuickSort.quickSort(quickAlmost);
        long quickTime = System.nanoTime() - start;
        System.out.println("Quick Sort almost-sorted | " + quickComp + " | " + quickTime);
    }

    private static int[] generateAscending(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static int[] copyArray(int[] values) {
        int[] copy = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            copy[i] = values[i];
        }
        return copy;
    }

    private static void swapAdjacentPairs(int[] arr, int pairs) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1 && swaps < pairs; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            swaps++;
        }
    }
}
