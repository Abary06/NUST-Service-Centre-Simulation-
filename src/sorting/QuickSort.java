package sorting;

public class QuickSort {
    private static int comparisons = 0;

    public static int quickSort(int[] arr) {
        comparisons = 0;
        sort(arr, 0, arr.length - 1);
        return comparisons;
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);
        sort(arr, low, pivotIndex - 1);
        sort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
