package sorting;

public class SelectionSort {
    public static int selectionSort(int[] arr) {
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }
        }
        System.out.println("Selection sort comparisons: " + comparisons + ", swaps: " + swaps);
        return comparisons;
    }
}
