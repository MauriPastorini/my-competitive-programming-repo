/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectionAlgorithms;

/**
 *
 * @author Mauri-Laptop
 */
public class QuickSelect {

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        return quickSelect(left, right, nums.length - k + 1, nums);
    }

    public int findKthSmallest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        return quickSelect(left, right, k, nums);
    }

    private int partition(int left, int right, int pivot, int[] nums) {
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < nums[pivot]) {
                i++;
                swap(i, j, nums);
            }
        }
        i++;
        swap(i, pivot, nums);

        return i;
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    private int quickSelect(int left, int right, int k, int[] nums) {
        int pivot = right;
        int index = partition(left, right, pivot, nums);
        if (index + 1 == k) {
            return nums[index];
        }
        if (index + 1 < k) {
            return quickSelect(index + 1, right, k, nums);
        }
        return quickSelect(left, index - 1, k, nums);
    }
}
