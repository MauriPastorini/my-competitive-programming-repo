/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Mauri-Laptop
 */
public class CardFlippingGame {

    void test() {
        int[] fronts = {4, 4, 4, 3, 3};
        int[] backs = {3, 3, 3, 2, 2};
        System.out.println(flipgame(fronts, backs));
    }

    public int flipgame(int[] f, int[] b) {
        HashSet<Integer> same = new HashSet<>();
        for (int i = 0; i < f.length; ++i) {
            if (f[i] == b[i]) {
                same.add(f[i]);
            }
        }
        int res = 3000;
        for (int i : f) {
            if (!same.contains(i)) {
                res = Math.min(res, i);
            }
        }
        for (int i : b) {
            if (!same.contains(i)) {
                res = Math.min(res, i);
            }
        }
        if (res == 3000) {
           return 0; 
        }
        return res;
    }

    public int flipgameMio(int[] fronts, int[] backs) {
        int[] frontAux = fronts.clone();
        Arrays.sort(frontAux, 0, fronts.length);

        int[] backAux = backs.clone();
        Arrays.sort(backAux, 0, fronts.length);

        int posF = 0;
        int posB = 0;
        while (posF < fronts.length || posB < backs.length) {

            int[] originalFOrB = fronts;
            int[] auxFOrBContrary = backs;
            int[] auxSort = frontAux;
            int min = 0;
            int pos = posF;
            int minF = Integer.MAX_VALUE;
            int minB = Integer.MAX_VALUE;
            if (posF < fronts.length) {
                minF = frontAux[posF];
            }
            if (posB < backAux.length) {
                minB = backAux[posB];
            }
            if (minF <= minB) {
                min = frontAux[posF];
                auxSort = frontAux;
                originalFOrB = fronts;
                auxFOrBContrary = backs;
                pos = posF;
                posF++;
            } else if (posB < backs.length) {
                min = backAux[posB];
                auxSort = backAux;
                originalFOrB = backs;
                auxFOrBContrary = fronts;
                pos = posB;
                posB++;
            }
            int posMin = 0;
            while (originalFOrB[posMin] != min) {
                posMin++;
            }
            boolean correct = true;
            for (int i = 0; i < originalFOrB.length && correct; i++) {
                if (originalFOrB[i] == min && auxFOrBContrary[i] == min) {
                    correct = false;
                }
            }
            if (correct) {
                return min;
            }
        }
        return 0;
    }
}
