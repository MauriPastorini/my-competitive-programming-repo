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
public class SingleElementInASortedArray {

    /*
        O(log n): Binary Search 
     */
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int cantI = mid - start + 1;

            if (cantI % 2 == 0) {
                if (nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid - 1] == nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        return nums[start];
    }

    /*
        O(n): Complete search
     */
    public int singleNonDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int actual = nums[0];
        for (int i = 1; i < nums.length; i++) {
            actual += i % 2 == 0 ? nums[i] : -nums[i];
            if (actual < 0) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public void test() {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }
}
