/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mauri-Laptop
 */
public class MaxProffit {

    public void test() {
        int[] p = {6, 1, 3, 2, 4, 7};
        System.out.println(maxProfit(p));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int stock = 0;
        int prof = 0;
        Map<Character, Integer> map = new HashMap<>();
        int pos = 1;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < max) {
                prof += max - min;
                min = prices[i];
                max = prices[i];
            } else {
                max = Math.max(max, prices[i]);
            }
        }
        prof += max - min;
        return prof;
    }
}
