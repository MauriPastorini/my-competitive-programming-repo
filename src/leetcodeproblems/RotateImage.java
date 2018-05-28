/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.Arrays;

/**
 *
 * @author Mauri-Laptop
 */
public class RotateImage {

    static public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        for (int i = 0; i <= rows / 2; i++) {
            for (int j = i; j < cols - i; j++) {
                int aux1 = matrix[i][j];
                int aux2 = matrix[j][cols - i];
                int aux3 = matrix[cols - i][cols - j];
                int aux4 = matrix[cols - j][i];

                matrix[i][j] = aux4;
                matrix[j][cols - i] = aux1;
                matrix[cols - i][cols - j] = aux2;
                matrix[cols - j][i] = aux3;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[5][5];
        nums[0] = new int[]{5, 1, 9, 11, 55};
        nums[1] = new int[]{2, 4, 8, 10, 56};
        nums[2] = new int[]{13, 3, 6, 7, 57};
        nums[3] = new int[]{15, 14, 12, 16, 58};
        nums[4] = new int[]{60, 61, 62, 63, 64};
        rotate(nums);
        for (int[] i : nums) {
            System.out.println(Arrays.toString(i));
        }
    }
}
