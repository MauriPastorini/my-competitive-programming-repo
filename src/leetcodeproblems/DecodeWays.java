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
public class DecodeWays {

    void test(){
        System.out.println(numDecodings("226"));
    }
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        return rec(0, 0, s,dp);
    }

    private int rec(int i, int j, String s,int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        if (i >= s.length()) {
            return 1;
        }
        boolean isInRange = true;
        int sumPos = 0;
        for (int k = 1; j + k <= s.length() && isInRange; k++) {
            int number = Integer.parseInt(s.substring(i, j + k));
            if (number > 26 || number<=0) {
                isInRange = false;
            } else {
                sumPos += rec(j + k, j + k, s, dp);
            }
        }
        dp[i] = sumPos;
        return sumPos;
    }
}
