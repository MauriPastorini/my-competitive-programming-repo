/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Mauri-Laptop
 */
public class ShuffleAnArray {

    int[] nums;
    int[] originalNums;

    public ShuffleAnArray() {
        this.nums = nums;
        this.originalNums = nums;
    }

    public void Solution(int[] nums) {
        this.nums = nums;
        this.originalNums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public void test() {
//        int[] nums = {1, 3, 2, 5};
//        Solution(nums);
//        int[] res = shuffle();
//        for (int i : res) {
//            System.out.println(i);
//        }
        
        Random rand = new Random();
        System.out.println(rand.nextInt(1));

    }

    public int[] reset() {
        this.nums = this.originalNums;
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random rand = ThreadLocalRandom.current();
        for (int i = nums.length - 1; i >= 1; i--) {
            int posRand = rand.nextInt(i);
            int aux = nums[posRand];
            nums[posRand] = nums[i];
            nums[i] = aux;
        }
        return this.nums;
    }
}
