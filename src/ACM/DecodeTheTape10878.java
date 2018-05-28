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
public class DecodeTheTape10878 {

    public static void main() {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String res = "";
        int sum = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            if (line.equals("___________") && sum == 10) {
                break;
            }
            if (sum != 0) {
                res = res + (char) sum;
            }
            sum = 0;
            int digit = 0;
            for (int i = line.length() - 2; i > 0; i--) {

                if (line.charAt(i) == 'o') {
                    sum += Math.pow(2, digit);
                }
                if (line.charAt(i) != '.') {
                    digit++;
                }
            }

        }
        System.out.println(res);
    }
}
