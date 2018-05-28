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
public class RepeatedSubstringPattern {

    void test() {
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 1) {
            return false;
        }
        List<Integer> lst = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(0)) {
                lst.add(i);
            }
        }
        for (int j = 0; j < lst.size(); j++) {
            String pat = s.substring(0, lst.get(j));
            int n = pat.length();

            boolean found = true;
            int i;
            if (s.length() % n == 0) {
                for (i = 0; i <= s.length() - n; i = i + n) {
                    String patToCompare = s.substring(i, i + n);
                    if (!pat.equals(patToCompare)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
}
