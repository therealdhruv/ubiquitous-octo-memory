package PhaseOne;
import java.util.*;

public class SortWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        // choose the last element as the pivot
        int pivot = arr[high];

        // initialize the index of the smaller element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, j, i);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}



/*
 *
 * There are 2 main approaches -
 *
 * (i) Quick Sort (Time Complexity: O(N log N) [O(N^2) in the worst case] and Space Complexity: O(log N))
 *
 * (ii) Merge Sort (Time Complexity: O(N log N) * always * and Space Complexity: O(N))
 *
 *
 * */


