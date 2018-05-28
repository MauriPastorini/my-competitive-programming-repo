/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import domain.TreeNode;

/**
 *
 * @author Mauri-Laptop
 */
public class MaximumBinaryTree {

    private static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int pos = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[pos]);
        root.left = constructMaximumBinaryTree(nums, start, pos - 1);
        root.right = constructMaximumBinaryTree(nums, pos + 1, end);
        return root;

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private static int findMax(int[] nums, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println("");
    }
}
