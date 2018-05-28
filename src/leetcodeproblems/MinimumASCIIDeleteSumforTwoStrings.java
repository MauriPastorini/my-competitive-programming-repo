package leetcodeproblems;

public class MinimumASCIIDeleteSumforTwoStrings {

    public void test() {
        System.out.println(minimumDeleteSum("", ""));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i - 1);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i - 1);
            
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int val1 = dp[i][j - 1] + s2.charAt(j - 1);
                    int val2 = dp[i - 1][j] + s1.charAt(i - 1);
                    dp[i][j] = Integer.min(val1, val2);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
