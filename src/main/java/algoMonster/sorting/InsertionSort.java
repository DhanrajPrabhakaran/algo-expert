package algoMonster.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 32, 12, 1, 2, 3, 4, 9, 3, 3};
        insertionSort(arr);
        System.out.println("Insertion sort: " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int current = i;
            while (current > 0 && arr[current] < arr[current - 1]){
                swap(arr, current, current - 1);
                current--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
