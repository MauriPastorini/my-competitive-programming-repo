package leetcodeproblems;

public class MagicSquaresInGrid {

    public void test() {
        int[][] grid
                = {
                    {4, 3, 8, 4},
                    {9, 4, 3, 8},
                    {2, 9, 5, 1},
                    {2, 2, 7, 6}};
        System.out.println(numMagicSquaresInside(grid));
    }

    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cant = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (checkIfIsMagic(i, j, grid)) {
                    cant++;
                }
            }
        }
        return cant;
    }

    private boolean checkIfIsMagic(int i, int j, int[][] grid) {
        boolean[] numbers = new boolean[10];
        int sum = -1;
        for (int k = i; k < i + 3; k++) {
            int sumaActual = 0;
            for (int l = j; l < j + 3; l++) {
                if (k >= grid.length) {
                    return false;
                }
                if (l >= grid[i].length) {
                    return false;
                }
                int n = grid[k][l];
                sumaActual += grid[k][l];
                if (n > 9 || n <= 0) {
                    return false;
                }
                if (numbers[n]) {
                    return false;
                }
                numbers[n] = true;

            }
            sum = sumaActual;
        }
        //cols
        int col1 = 0;
        int col2 = 0;
        int col3 = 0;

        col1 += grid[i][j];
        col1 += grid[i][j + 1];
        col1 += grid[i][j + 2];

        col2 += grid[i + 1][j];
        col2 += grid[i + 1][j + 1];
        col2 += grid[i + 1][j + 2];

        col3 += grid[i + 2][j];
        col3 += grid[i + 2][j + 1];
        col3 += grid[i + 2][j + 2];

        if (col1 != sum || col2 != sum || col3 != sum) {
            return false;
        }

        int pos = 2;
        int sumaDiago1 = 0;
        int sumaDiago2 = 0;

        sumaDiago1 += grid[i][j];
        sumaDiago1 += grid[i + 1][j + 1];
        sumaDiago1 += grid[i + 2][j + 2];

        sumaDiago2 += grid[i][j + 2];
        sumaDiago2 += grid[i + 1][j + 1];
        sumaDiago2 += grid[i + 2][j];

        if (sumaDiago1 != sum || sumaDiago2 != sum) {
            return false;
        }
        return true;
    }

}
