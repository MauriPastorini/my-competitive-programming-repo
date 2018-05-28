/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mauri-Laptop
 */
public class singleNumber {

    void test() {

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> elems = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (elems.containsKey(nums[i])) {
                elems.remove(i);
            } else {
                elems.put(new Integer(nums[i]), true);
            }
        }
        return elems.entrySet().iterator().next().getKey();
    }
}
