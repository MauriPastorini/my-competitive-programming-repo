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
public class SortColors {

    void test() {
        int[] nums = {2, 0, 2, 1,2,1,0,0,0,1,2, 1, 0};
        sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void sortColors(int[] nums) {
        int min = 0;
        int max = 2;

        int[] ocur = new int[max - min + 1];

        for (int i = 0; i < nums.length; i++) {
            ocur[nums[i]]++;
        }
        for (int i = 1; i < ocur.length; i++) {
            ocur[i] = ocur[i] + ocur[i-1];
        }
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[ocur[nums[i]]-1] = nums[i];
            ocur[nums[i]]--;
        }
        System.arraycopy(sorted, 0, nums, 0, sorted.length);
    }
}
