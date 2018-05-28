/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mauri-Laptop
 */
public class HierogliphsDecoder10841 {

    public static void main() {
        Scanner in = new Scanner(System.in);
        char[][] mat;
        int cols = Integer.parseInt(in.nextLine());
        for (int i = 0; i < cols; i++) {
            String line = "";
            do {
                line = in.nextLine();
            } while (line.isEmpty());
            int l = line.length();
            mat = new char[8][l];
            for (int j = 0; j < 8; j++) {
                String row = in.nextLine();
                mat[j] = row.toCharArray();
            }
            in.nextLine();
            decodeMat(mat);
        }
    }

    private static void decodeMat(char[][] mat) {
        String msg = "";
        for (int j = mat[0].length - 2; j > 0; j--) {
            int suma = 0;
            for (int i = mat.length - 1; i >= 0; i--) {
                char elem = mat[i][j];
                if (elem != '/') {
                    suma += Math.pow(2, i);
                }
            }
            msg =  (char) suma + msg;
        }
        System.out.println(msg);
    }
}
