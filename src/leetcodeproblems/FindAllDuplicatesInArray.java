package leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInArray {

    public static int[] sort(int[] array) {

        // array to be sorted in, this array is necessary
        // when we sort object datatypes, if we don't, 
        // we can sort directly into the input array     
        int[] aux = new int[array.length];

        // find the smallest and the largest value
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        // init array of frequencies
        int[] counts = new int[max - min + 1];

        // init the frequencies
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }

        // recalculate the array - create the array of occurences
        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        /*
      Sort the array right to the left
      1) Look up in the array of occurences the last occurence of the given value
      2) Place it into the sorted array
      3) Decrement the index of the last occurence of the given value
      4) Continue with the previous value of the input array (goto set1), 
         terminate if all values were already sorted
         */
        for (int i = array.length - 1; i >= 0; i--) {
            aux[counts[array[i] - min]--] = array[i];
        }
        return aux;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lst;
        }
        nums = sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                lst.add(nums[i]);
            }
        }
        return lst;
    }

    public void test() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> lst = findDuplicates(nums);
        System.out.println("");
    }

}
