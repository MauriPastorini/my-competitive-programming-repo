package leetcodeproblems;

import java.util.Arrays;

public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] cols = new int[grid[0].length];
        int[] rows = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            int maxCols = Integer.MIN_VALUE;
            int maxRows = Integer.MIN_VALUE;
            for (int j = 0; j < grid[i].length; j++) {
                maxCols = Integer.max(maxCols, grid[j][i]);
                maxRows = Integer.max(maxRows, grid[i][j]);
            }
            rows[i] = maxRows;
            cols[i] = maxCols;
        }
        int[][] res = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res[i][j] = Integer.min(rows[i], cols[j]);
                sum += res[i][j] - grid[i][j];
            }
        }
        return sum;
    }
}
