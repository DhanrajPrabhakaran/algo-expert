package algoMonster.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 2, 3, 4, 2, 2, 1, 1, 1, 2, 3, 4, 28, 28, 8};
        int[] nums = {6, 2, 3, 4, 8, 23, 2, 2, 1, 1, 1, 2, 3, 4};
        System.out.println("Kth Unique Largest element: "  + largestUnique(arr, 3));
        System.out.println("Kth Largest element: "  + largest(arr, 6));
        bubbleSort(arr);
        System.out.println("Bubble sort: "  + Arrays.toString(arr));
        bubbleSortDesc(nums);
        System.out.println("Bubble sort descending order: "  + Arrays.toString(nums));
    }

    private static void bubbleSortDesc(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1])
                    swap(nums, i, i - 1);
            }
        }
    }

    private static int largestUnique(int[] arr, int k) {
        int n = k;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int[] num = new int[k];
        int min = 0;
        while (n > 0) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i])
                    swap(arr, i, i - 1);
            }
            if (set.add(arr[arr.length - n - 1])) {
                num[count++] = arr[arr.length - n - 1];
                n--;
            }
        }
        return num[0];
    }

    private static int largest(int[] arr, int k) {
        int n = k;
        while (n > 0) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i])
                    swap(arr, i, i - 1);
            }
            n--;
        }
        return arr[arr.length - k];
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
