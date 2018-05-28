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
public class NewClass {

    public static int findLengthOfLCIS(int[] nums) {
        int actual = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                actual++;
            } else {
                max = Integer.max(max, actual);
                actual = 1;
            }
        }
        max = Integer.max(max, actual);
        actual = 1;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
    }
}
