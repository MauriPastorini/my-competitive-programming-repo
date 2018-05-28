/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACM;

import java.util.Scanner;

/**
 *
 * @author Mauri-Laptop
 */
public class Etapa2Divisiones {

    public static void main() {
        Scanner in = new Scanner("4 3\n"
                + "5 1 1 2\n"
                + "5 2 2");
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] values = str.split(" ");
            int n1 = Integer.parseInt(values[0]);
            int n2 = Integer.parseInt(values[1]);

            String[] r1 = in.nextLine().split(" ");
            String[] r2 = in.nextLine().split(" ");

            double r1Sum = 0;
            for (int i = n1 - 1; i >= 0; i--) {
                int n = Integer.parseInt(r1[i]);
                if (i != 0) {
                    r1Sum = 1 / (r1Sum + n);
                } else {
                    r1Sum = n + r1Sum;
                }
            }
            double r2Sum = 0;
            for (int i = n2 - 1; i >= 0; i--) {
                int n = Integer.parseInt(r2[i]);
                if (i != 0) {
                    r2Sum = 1 / (r2Sum + n);
                } else {
                    r2Sum = n + r2Sum;
                }
            }

            int i = 0;
            int sum = 0;
            while (i < n1 || i < n2) {
                int aux1 = 0, aux2 = 0;
                if (i < n1) {
                    aux1 = Integer.parseInt(r1[i]);
                }
                if (i < n2) {
                    aux2 = Integer.parseInt(r2[i]);
                }

                if (i == 0) {
                    sum = aux1 + aux2;
                } else {
                     
                }

            }

            System.out.println(r1Sum);
            System.out.println(r2Sum);
            System.out.println(r1Sum + r2Sum);
            System.out.println(r1Sum - r2Sum);
            System.out.println(r1Sum * r2Sum);
            System.out.println(r1Sum / r2Sum);

        }
    }
}
