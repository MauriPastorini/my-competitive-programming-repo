/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.Arrays;

/**
 *
 * @author Mauri-Laptop
 */
public class NumberofLongestIncreasingSubsequence {

    public void test() {
//        int[] nums = {1, 3, 5, 4, 7};
//        int[] nums = {2, 2, 2, 2, 2};
//        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3};
//        int[] nums = {2, 4, 1, 3};
//        int[] nums = {6, 57, 75, 65, 4, 1, -22, 66, 16, 19, -31, 87, -23, 34, 28, 42, 43, 23, 57, 38, 21, 4, 31, 13, 92, 5, 51, 41, 83, 74, 80, 49, 17, 48, 73, 43, 73, 34, -10, 81, 2, 88, 8, -27, 4, 59, 44, 61, 24, 41, 60, 50, 49, -12, 95, 46, -74, 33, 66, 5, 9, 7, 97, 39, 41, -66, 15, 95, 47, 91, 82, 73, 54, 96, 88, 53, 75, -92, 71, 79, -78, 67, 43, -51, 68, 83, 28, 96, 73, 59, 95, 95, 41, 46, 61, 19, -10, 7, 28, 80};
        System.out.println(findNumberOfLIS(nums));
    }

    //Solucion del ejercicio, la diferencia con el mio es que metio los dos dp array en un solo doble for. Es un poco mas optimo que el mio
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return N;
        }
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);
        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    //Mio
    public int findNumberOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] dpWays = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int actualMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    actualMax = Integer.max(actualMax, dp[j] + 1);
                }
            }
            dp[i] = actualMax;
            max = Integer.max(max, actualMax);
        }
        dpWays[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i] == 1) {
                dpWays[i] = 1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 == dp[i] && nums[j] < nums[i]) {
                    dpWays[i] += dpWays[j];
                }
            }
        }
        int cant = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                cant += dpWays[i];
            }
        }
        return cant;
    }
}
