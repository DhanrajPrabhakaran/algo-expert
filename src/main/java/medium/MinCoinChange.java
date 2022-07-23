package medium;

import java.util.Arrays;

public class MinCoinChange {
    public static void main(String[] args) {
        int[] denoms = {1, 2};
        int num = 3;
        System.out.println(minCoins(denoms, num));
    }

    private static int minCoins(int[] denoms, int num) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int compare = 0;

        for (int coin: denoms) {
            for (int amount = 1; amount <= num; amount++) {
                if (coin <= amount) {
                    if (dp[amount - coin] == Integer.MAX_VALUE)
                        compare = dp[amount - coin];
                    else
                        compare = dp[amount - coin] + 1;
                    dp[amount] = Math.min(dp[amount], compare);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[num] != Integer.MAX_VALUE ? dp[num] : -1;
    }
}
