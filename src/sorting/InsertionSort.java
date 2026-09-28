package sorting;

public class InsertionSort {
    public static int insertionSort(int[] arr) {
        int comparisons = 0;
        int shifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        System.out.println("Insertion sort comparisons: " + comparisons + ", shifts: " + shifts);
        return comparisons;
    }
}
