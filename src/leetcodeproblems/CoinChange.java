package leetcodeproblems;

import java.util.Arrays;

public class CoinChange {

    public void test() {
        int[] nums = {2, 3};
        System.out.println(coinChange(nums, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int N = coins.length;
        int[][] dp = new int[amount + 1][N + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (coins[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int valIzq = dp[i][j - 1] == 0 ? Integer.MAX_VALUE : dp[i][j - 1];

                    int valDer = dp[i - coins[j - 1]][j];
                    if (valDer == 0 && i - coins[j - 1] != 0) {
                        valDer = Integer.MAX_VALUE;
                    } else {
                        valDer++;
                    }
                    if (valDer == Integer.MAX_VALUE && valIzq == Integer.MAX_VALUE) {
                        valDer = 0;
                    }
                    dp[i][j] = Integer.min(valDer, valIzq);
                }
            }
        }
        int lastVal = dp[dp.length - 1][dp[0].length - 1];
        return lastVal == 0 ? -1 : lastVal;

    }

    public int coinChangeV1(int[] coins, int amount) {
        int[] values = new int[amount + 1];
        Arrays.fill(values, 0, values.length, Integer.MAX_VALUE);
        values[0] = 0;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i < values.length; i++) {
                if (i >= coins[j]) {
                    values[i] = Math.min(values[i - coins[j]] + 1, values[i]);
                }
            }
        }
        return values[amount] != Integer.MAX_VALUE ? values[amount] : -1;
    }
}
