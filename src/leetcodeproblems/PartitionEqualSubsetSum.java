package leetcodeproblems;

import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubsetSum {

    public void test() {
        int[] nums = {2,4,4};
        System.out.println(canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int limit = sum / 2;
        int[][] dp = new int[nums.length + 1][limit + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j >= nums[i - 1]) {
                    int usingVal = dp[i - 1][j - nums[i - 1]] + nums[i - 1];
                    int notUsing = dp[i - 1][j];
                    dp[i][j] = Integer.max(usingVal, notUsing);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int iAux = nums.length;
        int jAux = limit;
        List<Integer> setValues = new ArrayList<>();
        while (dp[iAux][jAux] != 0) {
            if (dp[iAux][jAux] == dp[iAux - 1][jAux]) {
                iAux--;
            } else {
                setValues.add(nums[iAux - 1]);
                jAux -= nums[iAux - 1];
                iAux--;
            }
        }
        int sumRes = 0;
        for (Integer setValue : setValues) {
            sumRes += setValue;
        }
        return sumRes == limit;
    }
}
