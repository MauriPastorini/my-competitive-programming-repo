/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauri-Laptop
 */
public class Multiply {

    void test() {
        System.out.println(multiply("456112321", "123"));
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        char[] num1C = num1.toCharArray();
        char[] num2C = num2.toCharArray();
        List<String> str = new ArrayList<>();

        int ASCII = 48;

        for (int i = num2C.length - 1; i >= 0; i--) {
            int digit2 = ((int) num2C[i]) - ASCII;
            String res = "";
            int carr = 0;
            for (int j = num1C.length - 1; j >= 0; j--) {
                int digit1 = (int) num1C[j] - ASCII;
                int sum = digit2 * digit1 + carr;

                carr = 0;
                if (j != 0) {
                    while (sum >= 10) {
                        sum -= 10;
                        carr++;
                    }
                }
                res = sum + res;
            }
            str.add(res);
        }
        String s = str.get(0);

        StringBuilder res = new StringBuilder(str.get(0));
        int carr = 0;
        for (int i = 1; i < str.size(); i++) {
            String elem = str.get(i);
            int pos = res.length() - i - 1;
            for (int j = elem.length() - 1; j >= 0; j--) {
                int d = 0;
                d = (int) elem.charAt(j) - ASCII;
                int n = 0;
                if (pos >= 0) {
                    n = (int) res.charAt(pos) - ASCII;
                }
                int sum = d + n + carr;
                carr = 0;
                if (j != 0) {
                    while (sum >= 10) {
                        sum -= 10;
                        carr++;
                    }
                }
                String c = "" + sum;
                if (pos >= 0) {
                    res.replace(pos, pos + 1, c);
                } else {
                    res.insert(0, c);
                }
                pos--;
            }
        }
        int iaux = 0;
        while (iaux != res.length() - 1 && res.charAt(iaux) == '0') {
            res.delete(iaux, 1);
        }
        return res.toString();
    }
}
