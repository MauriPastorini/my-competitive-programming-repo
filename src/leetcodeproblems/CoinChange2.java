package leetcodeproblems;

import java.util.Arrays;

public class CoinChange2 {

    public void test() {
        int amount = 500;
        int[] coins = {3, 5, 7, 8, 9, 10, 11};//35502874
        amount = 0;
        int[] coins2 = {};//35502874
        System.out.println(change(amount, coins2));
    }

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        int[][] dp = new int[amount + 1][coins.length + 1];
        Arrays.sort(coins, 0, coins.length);
        for (int j = 1; j < dp[coins[0]].length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (i >= coins[j - 1]) {
                    dp[i][j] = dp[i - coins[j - 1]][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[amount][coins.length];
    }

    //TLE Recursion
    int cant = 0;

    public int change2(int amount, int[] coins) {
        cant = 0;
        contNums(0, coins, amount);
        return cant;
    }

    private void contNums(int i, int[] coins, int amount) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            cant++;
            return;
        }
        for (int j = i; j < coins.length; j++) {
            int aux = coins[j];
            if (amount - aux >= 0) {
                contNums(j, coins, amount - aux);
            }
        }
    }
}
