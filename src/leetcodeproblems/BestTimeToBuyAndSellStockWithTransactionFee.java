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
public class BestTimeToBuyAndSellStockWithTransactionFee {

    void test() {
        int[] d = {1, 3, 7, 5, 10, 3}; //4, 3
        System.out.println(maxProfit(d, 3));
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int max = Integer.MIN_VALUE;
        int prof = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                if (max == Integer.MIN_VALUE && prices[i] < min) {
                    min = prices[i];
                } else {
                    if (prices[i] + fee < max) {
                        prof += max - min - fee;
                        max = Integer.MIN_VALUE;
                        min = prices[i];
                    }
                }
            } else {
                if (prices[i] - fee > min && prices[i] > max) {
                    max = prices[i];
                }
            }
        }
        if (max > min + fee) {
            prof += max - min - fee;
        }
        return prof;
    }

}
