/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UVa;

import java.util.Scanner;

/**
 *
 * @author Mauri-Laptop
 */
public class PeriodicString455 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = Integer.parseInt(in.nextLine());
        while (c-- != 0) {
            in.nextLine();
            String line = in.nextLine();
            StringBuilder strBuil = new StringBuilder(line);
            strBuil.append(line);
            strBuil.replace(0, 1, "");
            strBuil.replace(strBuil.length() - 1, strBuil.length(), "");
            int i = (strBuil.toString().indexOf(line));
            if (i == -1) {
                System.out.println(line.length());
            } else {
                System.out.println(i + 1);
            }
            if (c != 0) {
                System.out.println("");
            }
        }
    }
}
