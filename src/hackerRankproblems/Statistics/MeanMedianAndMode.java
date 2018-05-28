package hackerRankproblems.Statistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeanMedianAndMode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = in.nextInt();
        int[] values = new int[cant];
        double sum = 0;
        for (int i = 0; i < cant; i++) {
            values[i] = in.nextInt();
            sum += values[i];
        }
        System.out.println(getRound(sum / values.length, 1));
        Arrays.sort(values, 0, values.length);
        int mid1 = values[values.length / 2];
        int mid2 = values.length % 2 != 0 ? mid1 : values[values.length / 2 - 1];
        System.out.println(getRound((mid1 + mid2) / 2.0, 1));
        System.out.println(getMode(values));

    }

    private static double getRound(double i, int exp) {
        double io = Math.pow(10, exp);
        return Math.round(i * io) / io;
    }

    private static int getMode(int[] values) {
        int actual = values[0];
        int actualCont = 1;
        int max = actualCont;
        int maxValue = actual;
        for (int i = 1; i <= values.length; i++) {
            int value = i < values.length ? values[i] : -actual;
            if (value != actual) {
                if (max <= actualCont) {
                    if (max == actualCont) {
                        maxValue = actual < maxValue ? actual : maxValue;
                    } else {
                        maxValue = actual;
                    }
                    max = actualCont;
                }
                actual = value;
                actualCont = 0;
            }
            actualCont++;
        }
        return maxValue;
    }
}
