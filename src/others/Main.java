/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s = "hola";
        String s2 = "ol";
        naiveMatching(s, s2);
    }

    static void naiveMatching(String a, String b) {
        char[] P = a.toCharArray();
        char[] T = b.toCharArray();
        int n = a.length();
        int m = b.length();
        for (int i = 0; i < n; i++) {
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if (i + j >= n || P[i] != T[i + j]) {
                    found = false;
                }
            }
            if (found) {
                System.out.printf("P is found at %d in T\n", i);
            }
        }
    }
}
