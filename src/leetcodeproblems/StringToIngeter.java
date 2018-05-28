/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.math.BigInteger;

/**
 *
 * @author Mauri-Laptop
 */
public class StringToIngeter {
    
    void test() {
        System.out.println(myAtoi("+"));
    }
    
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        if (str.length() == 1 && (str.equals("-") || str.equals("+")))  {
            return 0;
        }
        BigInteger big;
        boolean found = false;
        int pos = 0;
        boolean foundN = false;
        while (!found && pos < str.length()) {
            String s = String.valueOf(str.charAt(pos));
            if (pos == 0 && (s.equals("-") || s.equals("+"))) {
                pos++;
                continue;
            }
            try {
                Integer i = Integer.parseInt(s);
                foundN = true;
            } catch (Exception e) {
                if (!foundN) {
                    return 0;
                }
                found = true;
            }
            pos++;
        }
        if (found) {
            big = new BigInteger(str.substring(0, pos - 1));
        } else {
            big = new BigInteger(str.substring(0, pos));
        }
        int c = BigInteger.valueOf(Integer.MAX_VALUE).compareTo(big);
        if (c < 0) {
            return Integer.MAX_VALUE;
        }
        c = BigInteger.valueOf(Integer.MIN_VALUE).compareTo(big);
        if (c > 0) {
            return -Integer.MIN_VALUE;
        }
        return big.intValueExact();
    }
//    public int myAtoi(String str) {
//        if (str == null) {
//            return 0;
//        }
//        str = str.trim();
//        BigInteger big;
//        boolean found = false;
//        int pos = 1;
//        while (!found && pos < str.length()) {
//            String s = String.valueOf(str.charAt(pos));
//            try {
//                Integer i = Integer.parseInt(s);
//            } catch (Exception e) {
//                if (pos == 1) {
//                    return 0;
//                }
//                found = true;
//            }
//            pos++;
//        }
//        if (found) {
//
//            big = new BigInteger(str.substring(0, pos - 1));
//        } else {
//            big = new BigInteger(str.substring(0, pos));
//        }
//        if (big. > Integer.MAX_VALUE) {
//            Integer.
//        }
//        return big.intValue();
//    }
}
