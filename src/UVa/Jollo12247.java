/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UVa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
public class Jollo12247 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] values = in.nextLine().split(" ");
            boolean stop = false;
            int[] vals1 = new int[3];
            int[] vals2 = new int[2];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals("0")) {
                    stop = true;
                }
                if (i < 3) {
                    vals1[i] = Integer.parseInt(values[i]);
                } else {
                    vals2[i - 3] = Integer.parseInt(values[i]);
                }
                set.add(Integer.parseInt(values[i]));
            }
            if (stop) {
                break;
            }
//            Arrays.sort(vals1, 0, vals1.length);
//            Arrays.sort(vals2, 0, vals2.length);

            int princessWin = 0;
            int princeWin = 0;
            for (int i = 0; i < 2; i++) {
                int bestCard = vals2[2 - i - 1];
                int worstToWin = 53;
                int pos = -1;
                int posMin = -1;
                int min = 53;
                for (int j = 0; j < vals1.length; j++) {
                    if (vals1[j] != 53 && vals1[j] > bestCard && vals1[j] < worstToWin) {
                        worstToWin = vals1[j];
                        pos = j;
                    }
                    if (vals1[j] < min) {
                        min = vals1[j];
                        posMin = j;
                    }
                }
                if (pos != -1) {
                    princessWin++;
                    vals1[pos] = 53;
                    vals2[2 - i - 1] = 53;
                } else {
                    princeWin++;
                    vals1[posMin] = 53;
                    vals2[2 - i - 1] = 53;
                }
            }
            if (princessWin == 0) {
                int min = 1;
                while (set.contains(min) && min < 53) {
                    min++;
                }
                if (min == 53) {
                    System.out.println("-1");
                } else {
                    System.out.println(min);
                }
            } else if (princessWin == 2) {
                System.out.println("-1");
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < vals1.length; i++) {
                    min = Integer.min(min, vals1[i]);
                }
                min++;
                while (set.contains(min) && min < 53) {
                    min++;
                }
                if (min == 53) {
                    System.out.println("-1");
                } else {
                    System.out.println(min);
                }
            }

        }
    }

}
