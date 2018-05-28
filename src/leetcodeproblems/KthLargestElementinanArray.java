/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import javafx.scene.layout.Priority;

/**
 *
 * @author Mauri-Laptop
 */
public class KthLargestElementinanArray {

    public void test() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums2 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 4));
    }

    //Quick Select
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        return quickSelect(left, right, nums.length - k + 1, nums);

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

    //Heap
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            queue.poll();
        }
        return queue.poll();
    }

    //Slower
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums, 0, nums.length);
        return nums[nums.length - k];
    }
}
