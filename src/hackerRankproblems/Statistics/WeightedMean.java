package hackerRankproblems.Statistics;

import java.util.Scanner;

public class WeightedMean {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = in.nextInt();
        int[] values = new int[cant];
        for (int i = 0; i < cant; i++) {
            values[i] = in.nextInt();
        }
        int sumTop = 0;
        double sumBot = 0;
        for (int i = 0; i < cant; i++) {
            int weigth = in.nextInt();
            sumTop += values[i]*weigth;
            sumBot += weigth;
        }
        System.out.println((Math.round(sumTop / sumBot * 10.0) / 10.0));
    }
    
     private static double getRound(double i, int exp) {
        double io = Math.pow(10, exp);
        return Math.round(i * io) / io;
    }
}
