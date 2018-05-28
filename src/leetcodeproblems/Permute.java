/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauri-Laptop
 */
public class Permute {
    
    void test(){
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> i : res){
            for(Integer n : i){
                System.out.print(i + ",");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        rec(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void rec(List<List<Integer>> res, List<Integer> actual, int[] nums, boolean[] visited) {
        if (actual.size() == nums.length) {
            res.add(new ArrayList<>(actual));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Integer num = nums[i];
                actual.add(num);
                rec(res, actual, nums, visited);
                visited[i] = false;
                actual.remove(num);
            }
        }
    }
}
