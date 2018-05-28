/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mauri-Laptop
 */
public class FourSumCount {

    void test() {
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};

        System.out.println(fourSumCount(A, B, C, D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cant = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map1.containsKey(sum)) {
                    map1.put(sum, map1.get(sum) + 1);
                } else {
                    map1.put(sum, 1);
                }
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int dif = -C[i] - D[j];
                if (map1.containsKey(dif)) {
                    cant += map1.get(dif);
                }
            }
        }
        return cant;
    }
}
