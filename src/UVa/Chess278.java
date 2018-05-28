/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UVa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mauri-Laptop
 */
public class Chess278 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = in.nextInt();
        in.nextLine();
        while (cant-- != 0) {
            String[] line = in.nextLine().split(" ");
            int m = Integer.parseInt(line[1]);
            int n = Integer.parseInt(line[2]);
            switch (line[0]) {
                case "r":
                    System.out.println(Integer.min(m, n));
                    break;
                case "Q":
                    System.out.println(Integer.min(m, n));
                    break;
                case "K":
                    System.out.println((++m / 2) * (++n / 2));
                    break;
                case "k":
                    int i = (((m + 1) / 2) * ((n + 1) / 2)) + (((m) / 2) * ((n) / 2));
                    System.out.println(i);
                    break;
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner("2\n"
//                + "Q 8 8\n"
//                + "Q 10 10");
//        int cant = in.nextInt();
//        in.nextLine();
//        while (cant-- != 0) {
//            String[] line = in.nextLine().split(" ");
//            int m = Integer.parseInt(line[1]);
//            int n = Integer.parseInt(line[2]);
//            boolean[][] possibilities = new boolean[m][n];
//            int max = checkRec(line[0], possibilities, 0, 0);
//            System.out.println(max);
//        }
//    }
//
//    private static int checkRec(String piece, boolean[][] notPossibleMat, int i, int j) {
//        if (j == notPossibleMat[i].length) {
//            i++;
//            j = 0;
//        }
////        System.out.printf("%d - %d", i, j);
////        System.out.println("");
//        if (i >= notPossibleMat.length || j >= notPossibleMat[i].length) {
//            return 0;
//        }
//        int with = Integer.MIN_VALUE;
//        if (!notPossibleMat[i][j]) {
//            boolean[][] newMatrix = new boolean[notPossibleMat.length][];
//            for (int k = 0; k < newMatrix.length; k++) {
//                newMatrix[k] = notPossibleMat[k].clone();
//            }
//            fillMatrix(newMatrix, piece, i, j);
//            newMatrix[i][j] = true;
//            with = checkRec(piece, newMatrix, i, j + 1) + 1;
//        }
//
//        int without = checkRec(piece, notPossibleMat, i, j + 1);
//        return Integer.max(with, without);
//    }
//
//    static int[] knightMovesRow = {2, 2, -2, -2, -1, -1, 1, 1};
//    static int[] knightMovesCol = {1, -1, 1, -1, 2, -2, 2, -2};
//
//    static int[] kingMovesRow = {0, 1, -1};
//    static int[] kingMovesCol = {0, 1, -1};
//
//    private static void fillMatrix(boolean[][] notPossibleMat, String piece, int i, int j) {
//        switch (piece) {
//            case "r":
//                for (int k = 0; k < notPossibleMat.length; k++) {
//                    notPossibleMat[k][j] = true;
//                }
//                for (int k = 0; k < notPossibleMat[i].length; k++) {
//                    notPossibleMat[i][k] = true;
//                }
//                break;
//            case "k":
//                for (int k = 0; k < knightMovesRow.length; k++) {
//                    if (i + knightMovesRow[k] >= 0 && i + knightMovesRow[k] < notPossibleMat.length && j + knightMovesCol[k] >= 0 && j + knightMovesCol[k] < notPossibleMat[i].length) {
//                        notPossibleMat[i + knightMovesRow[k]][j + knightMovesCol[k]] = true;
//                    }
//                }
//                break;
//            case "Q":
//                for (int k = 0; k < notPossibleMat.length; k++) {
//                    notPossibleMat[k][j] = true;
//                }
//                for (int k = 0; k < notPossibleMat[i].length; k++) {
//                    notPossibleMat[i][k] = true;
//                }
//                boolean cantT = false;
//                boolean cantB = false;
//                for (int k = i; cantT || cantB; k++) {
//                    if (i + k < notPossibleMat.length && j + k < notPossibleMat[i].length) {
//                        notPossibleMat[i + k][j + k] = true;
//                    } else {
//                        cantT = false;
//                    }
//                    if (i - k >= 0 && j - k >= 0) {
//                        notPossibleMat[i - k][j - k] = true;
//                    } else {
//                        cantB = false;
//                    }
//                }
//                break;
//            case "K":
//                for (int k = 0; k < kingMovesRow.length; k++) {
//                    for (int l = 0; l < kingMovesCol.length; l++) {
//                        if (i + kingMovesRow[k] >= 0 && i + kingMovesRow[k] < notPossibleMat.length && j + kingMovesCol[l] >= 0 && j + kingMovesCol[1] < notPossibleMat[i].length) {
//                            notPossibleMat[i + kingMovesRow[k]][j + kingMovesRow[l]] = true;
//                        }
//                    }
//                }
//                break;
//        }
//    }
}
