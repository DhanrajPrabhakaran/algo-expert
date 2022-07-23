package easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
    public static void main(String[] args) {
        String[][] arr = {{"HTML", "C#"},{"C#", "Python"},{"Python", "HTML"}};
        int[] result = {0, 0, 1};
        System.out.println("Tournament winner: " + tournament(arr, result));
    }
    /**     Time complexity: O(n)
     *      Space complexity: O(n)
     *      store the result in hashmap and print the highest values key
     * */
    private static String tournament(String[][] arr, int[] result) {
        int r = arr.length;
        String winner = "";
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < r; i++) {
            if (result[i] == 0) {
                map.put(arr[i][1], map.getOrDefault(arr[i][1], 0) + 3);
            } else {
                map.put(arr[i][0], map.getOrDefault(arr[i][0], 0) + 3);
            }
        }
        int max = Collections.max(map.values());
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == max)
                winner = entry.getKey();
        }
        return winner;
    }
}
