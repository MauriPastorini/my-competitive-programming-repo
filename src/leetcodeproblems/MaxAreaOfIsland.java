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
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, rec(grid, i, j));
                }
            }
        }
        return max;
    }

    private int rec(int[][] grid, int i, int j) {
        int cont;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            cont = 0;
        } else {
            cont = 1;
            grid[i][j] = 0;
            cont += rec(grid, i + 1, j);
            cont += rec(grid, i - 1, j);
            cont += rec(grid, i, j + 1);
            cont += rec(grid, i, j - 1);
        }
        return cont;
    }
}
