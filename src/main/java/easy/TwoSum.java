package easy;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println("Two Sum: " + Arrays.toString(twoSum1(arr, 10)));
        System.out.println("Two Sum: " + Arrays.toString(twoSum2(arr, 10)));
        System.out.println("Two Sum: " + Arrays.toString(twoSum3(arr, 10)));
        System.out.println("Two Sum: " + Arrays.toString(twoSum4(arr, 10)));

    }
    /**     Time complexity: O(n)
     *      Space complexity: O(n)
     *      Set to store the answer and find the result
     * */
    private static int[] twoSum4(int[] arr, int target) {
        int n = arr.length;
        if (n < 2)
            return new int[0];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int ans = target - arr[i];
            if (set.contains(ans))
                return new int[]{ans, arr[i]};
            else
                set.add(arr[i]);
        }
        return new int[0];
    }

    /**     Time complexity: O(n log n)
     *      Space complexity: O(1)
     *      sort the array and find the element using two pointers
     * */
    private static int[] twoSum3(int[] arr, int target) {
        int n = arr.length;
        if (n < 2)
            return new int[0];
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int[] result = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target)
                break;
            else if (sum < target)
                left++;
            else if (sum > target)
                right--;
        }
        result[0] = arr[left];
        result[1] = arr[right];
        return result;
    }

    /**     Time complexity: O(n)
     *      Space complexity: O(n)
     *      Hashmap to store the answer and find the result
     * */
    private static int[] twoSum2(int[] arr, int target) {
        int[] result = new int[2];
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        if (n < 2)
            return new int[0];
        for (int i = 0; i < n; i++){
            int ans = target - arr[i];
            map.put(ans, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]) && arr[i] != map.get(arr[i])) {
                result[0] = arr[i];
                result[1] = map.get(arr[i]);
            }
        }
        return result;
    }

    /**     Time complexity: O(n^2)
     *      Space complexity: O(1)
     *      Brute force - two loops to find target present
     * */
    private static int[] twoSum1(int[] arr, int target) {
        int n = arr.length;
        int[] result = new int[2];
        if (n < 2)
            return new int[0];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                }
            }
        }
        return result;
    }
}
