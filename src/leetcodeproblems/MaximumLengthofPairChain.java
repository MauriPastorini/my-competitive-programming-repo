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
public class MaximumLengthofPairChain {

    void test() {
        // {1, 7}, {9, 10}, {-4, 7}
        int[][] nums5 = {{-10, -8}, {8, 9}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}};

        int[][] nums2 = {{8, 9}, {-6, -4}, {1, 7}};

        int[][] nums = {{1, 2}, {3, 4}, {5, 6}};

        int[][] nums4 = {{1, 4}, {3, 4}, {6, 7}, {8, 9}};

        int[][] nums3 = {{1, 2}};

        int[][] nums6 = {{3, 4}, {1, 2}};

        System.out.println(findLongestChain(nums5));
    }

    public int findLongestChain(int[][] pairs) {

        int[] dp = new int[pairs.length + 1];
        int res = rec(pairs, dp, pairs.length - 1, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
        return res;
    }

    private int rec(int[][] pairs, int[] dp, int i, int value, int left, int right) {
        if (i < 0) {
            return value;
        }
        //System.out.println(pairs[i][0] + " , " + pairs[i][1]);

        int withNodeValue;
        if (pairs[i][1] < left) {
            withNodeValue = value + 1;
        } else {
            withNodeValue = value;
        }
        int withNodeValueInverted;
        if (pairs[i][0] > right) {
            withNodeValueInverted = value + 1;
        } else {
            withNodeValueInverted = value;
        }
        int withNode = rec(pairs, dp, i - 1, withNodeValue, pairs[i][0], pairs[i][1]);
        int withNodeInverted = rec(pairs, dp, i - 1, withNodeValueInverted, pairs[i][1], pairs[i][0]);
        int withoutNode = rec(pairs, dp, i - 1, value, left, right);

        int max = Math.max(withNode, withoutNode);
        max = Math.max(max, withNodeInverted);
        return max;
    }
}
