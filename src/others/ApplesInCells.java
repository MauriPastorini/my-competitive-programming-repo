package others;

import java.util.Arrays;

public class ApplesInCells {
    public void test(){
        int[][] apples = { { 1 , 5} , {3,6}, {10, 2}};
        System.out.println(collectApples(apples));
    }
    
    public int collectApples(int[][] cells){
        if (cells.length == 0) {
            return 0;
        }
        int[][] values = new int[cells.length + 1][cells[0].length + 1];
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < values[i].length; j++) {
                values[i][j] = Math.max(values[i][j - 1], values[i - 1][j]) + cells[i-1][j - 1];
            }
        }
        return values[values.length - 1][values[0].length - 1];
    }
}
