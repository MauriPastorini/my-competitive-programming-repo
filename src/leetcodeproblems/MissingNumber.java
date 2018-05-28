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
public class MissingNumber {

    void test() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int n = 0;
        int expec = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n += nums[i];
            expec += i;
        }
        return expec - n;
    }
}
