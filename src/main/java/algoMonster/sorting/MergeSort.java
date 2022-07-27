package algoMonster.sorting;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 22, 11, 43, 23, 32, 3, 1, 3, 4, 5, 1, 2 , 3, 4};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] arr) {
        if (arr.length < 2)
            return;
        int start = 0;
        int end = arr.length;

        // divide the array into half
        int middle = (start + end ) / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = arr[i];
        int[] right = new int[end - middle];
        for (int i = middle; i < end; i++)
            right[i - middle] = arr[i];

        // sort each half
        mergeSort(left);
        mergeSort(right);

        // merge the result
        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while (i < left.length)
            result[k++] = left[i++];
        while (j < right.length)
            result[k++] = right[j++];

    }
}
