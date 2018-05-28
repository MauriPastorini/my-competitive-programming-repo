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
public class KthSmallest {

    void test() {
         int[][] matrix = {
             {1,1,2},
             {1,1,3},
             {1,1,4}
         };
          int[][] matrix2 = {
             {1,5,9},
             {10,11,13},
             {12,13,15}
         };
         System.out.println(kthSmallest(matrix2, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int[] poss = new int[matrix.length];
        int min = Integer.MAX_VALUE;
        for (int mink = 0; mink < k; mink++) {
            min = Integer.MAX_VALUE;
            int minpos = 0;
            for (int i = 0; i < matrix.length; i++) {
                int j = poss[i];
                if (j < matrix[i].length && matrix[i][j] < min) {
                    min = matrix[i][j];
                    minpos = i;
                }
            }
            poss[minpos] += 1;
        }
        return min;
    }

}
