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
public class AutomatedCheckingMachine6821 {

    public static void main() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input1 = in.nextLine();
            String[] values1 = input1.split(" ");

            String input2 = in.nextLine();
            String[] values2 = input2.split(" ");

            boolean comp = true;
            for (int i = 0; i < values1.length; i++) {
                if (values1[i].equals("1")) {
                    if (!values2[i].equals("0")) {
                        comp = false;
                        break;
                    }
                } else {
                    if (!values2[i].equals("1")) {
                        comp = false;
                        break;
                    }
                }
            }

            if (!comp) {
                System.out.println("N");
            } else {
                System.out.println("Y");
            }
        }
    }
}
