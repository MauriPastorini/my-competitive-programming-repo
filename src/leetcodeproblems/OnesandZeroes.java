package leetcodeproblems;

public class OnesandZeroes {

    public void test() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
//        String[] strs = {"10", "0", "1"};
        System.out.println(findMaxForm(strs, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 0;
        }
        int[][] items = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int ceros = 0;
            int ones = 0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    ceros++;
                } else {
                    ones++;
                }
            }
            int[] item = {ceros, ones};
            items[i] = item;
        }

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int iStrs = 1; iStrs < dp.length; iStrs++) {
            int[] item = items[iStrs - 1];
            for (int iM = 0; iM <= m; iM++) {
                for (int iN = 0; iN <= n; iN++) {
                    if (iM >= item[0] && iN >= item[1]) {
                        int valueWithoutItem = dp[iStrs - 1][iM][iN];
                        int valWith = dp[iStrs - 1][iM - item[0]][iN - item[1]] + 1;
                        dp[iStrs][iM][iN] = Integer.max(valueWithoutItem, valWith);
                    } else {
                        dp[iStrs][iM][iN] = dp[iStrs - 1][iM][iN];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
