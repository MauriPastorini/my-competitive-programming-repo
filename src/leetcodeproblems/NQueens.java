/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mauri-Laptop
 */
public class NQueens {

    void test() {
        List<List<String>> lst = solveNQueens(2);
        for (List<String> l : lst) {
            for (String s : l) {
                System.out.println(s + " ");
            }
        }
    }
    static int m;

    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            List<String> lst = new ArrayList<>();
            lst.add("Q");
            fin.add(lst);
        }
        m = n;
        boolean[][] visited = new boolean[n][n];
        String[][] quens = backTracking(new Res(), 0, 0, visited).board;

        List<List<String>> res = new ArrayList<>();
        return fin;
    }

    private boolean[][] myClone(boolean[][] visited) {
        boolean[][] myCl = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                myCl[i][j] = visited[i][j];
            }
        }
        return myCl;
    }

    private String[][] myClone(String[][] board) {
        String[][] myCl = new String[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                myCl[i][j] = board[i][j];
            }
        }
        return myCl;
    }

    private List<String> add(String[][] board) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String line = "";
            for (int j = 0; j < board[i].length; j++) {
                line += board[i][j];
            }
            lst.add(line);
        }
        return lst;
    }

    private boolean myContains(String[][] board) {
        for (List<String> lst : fin) {
            boolean found = true;
            for (int i = 0; i < lst.size(); i++) {
                String comp = lst.get(i);
                String line = "";
                for (int j = 0; j < board[i].length; j++) {
                    line += board[i][j];
                }
                if (!comp.equals(line)) {
                    found = false;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }

    class Res {

        String[][] board;
        int count;

        Res() {
            count = 0;
            board = new String[m][m];
        }
    }

    int max = Integer.MIN_VALUE;
    List<List<String>> fin = new ArrayList<>();

    private Res backTracking(Res res, int i, int j, boolean[][] visited) {
        if (j >= res.board[i].length) {
            i++;
            j = 0;
        }
        if (i >= res.board.length) {
            return res;
        }

        Res bestRes = new Res();
        int count = res.count;

        Res without = new Res();
        without.count = res.count;
        without.board = myClone(res.board);
        without.board[i][j] = ".";
        Res resWithoutQueen = backTracking(without, i, j + 1, myClone(visited));
        int countWithout = resWithoutQueen.count;

        Res resWithQueen = new Res();
        if (!visited[i][j]) {
            Res with = new Res();
            with.count = res.count + 1;
            with.board = myClone(res.board);
            with.board[i][j] = "Q";

            boolean[][] visitedQueen = fill(myClone(visited), i, j);
            resWithQueen = backTracking(with, i, j + 1, visitedQueen);
        }

        if (resWithQueen.count > max || countWithout > max) {
            fin.clear();
            max = Math.max(resWithQueen.count, count);
        }
        if (max == resWithQueen.count) {
            if (!myContains(resWithQueen.board)) {
                fin.add(add(resWithQueen.board));
            }
        }
        if (max == countWithout) {
            if (!myContains(resWithoutQueen.board)) {
                fin.add(add(resWithoutQueen.board));
            }
        }
        if (resWithQueen.count >= countWithout) {

            bestRes = resWithQueen;
            bestRes.count = resWithQueen.count;
        } else {
            bestRes.count = countWithout;
            bestRes = resWithoutQueen;
        }
        return bestRes;
    }

    private boolean[][] fill(boolean[][] mat, int i, int j) {
        mat[i][j] = true;
        for (int auxI = 0; auxI < i; auxI++) {
            mat[auxI][j] = true;
        }
        for (int auxI = i + 1; auxI < mat.length; auxI++) {
            mat[auxI][j] = true;
        }
        for (int auxJ = 0; auxJ < j; auxJ++) {
            mat[i][auxJ] = true;
        }
        for (int auxJ = j + 1; auxJ < mat[i].length; auxJ++) {
            mat[i][auxJ] = true;
        }
        int auxI = i - 1;
        int auxJ = j - 1;
        while (auxI >= 0 && auxJ >= 0) {
            mat[auxI][auxJ] = true;
            auxI--;
            auxJ--;
        }
        auxI = i + 1;
        auxJ = j + 1;
        while (auxI < mat.length && auxJ < mat[i].length) {
            mat[auxI][auxJ] = true;
            auxI++;
            auxJ++;
        }

        auxI = i - 1;
        auxJ = j + 1;
        while (auxI >= 0 && auxJ < mat[i].length) {
            mat[auxI][auxJ] = true;
            auxI--;
            auxJ++;
        }
        auxI = i + 1;
        auxJ = j - 1;
        while (auxI < mat.length && auxJ >= 0) {
            mat[auxI][auxJ] = true;
            auxI++;
            auxJ--;
        }
        return mat;
    }
}
