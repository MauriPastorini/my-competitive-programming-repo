/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

/**
 *
 * @author Mauri-Laptop
 */
public class CountNumbersWithUniqueDigits {

    public void test() {
        System.out.println(countNumbersWithUniqueDigitsBest(2));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        if (n == 2) {
            return 91;
        }
        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];

        dp[1] = 0;
        dp[2] = 9;
        dp2[2] = 102;
        dp2[1] = 11;
        dp2[0] = 1;

        for (int i = 3; i <= n; i++) {
            int prevCorrect = ((int) Math.pow(10, i - 1) - dp[i - 1]);
            if (true) {
                dp[i] = 10 * dp[i - 1] + (i - 1) * prevCorrect - dp2[i - 2];
                dp2[i - 1] = dp2[i - 2] + (int) Math.pow(10, i - 1) - dp[i - 1];
            } else {
                dp[i] = 10 * dp[i - 1] + (i - 1) * prevCorrect - ((int) Math.pow(10, i - 2) - dp[i - 2]) - ((int) Math.pow(10, i - 3) - dp[i - 3]) - ((int) Math.pow(10, i - 4) - dp[i - 4]);
            }
        }
        return (int) Math.pow(10, n) - dp[n];
    }

    public int countNumbersWithUniqueDigitsBest(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int[] dp = new int[n + 1];
        dp[1] = 10;
        dp[2] = 81;
        int actual = 8;
        for (int i = 3; i <= n; i++) {
            dp[i] = actual * dp[i - 1];
            actual--;
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += dp[i];
        }
        return res;
    }

}
