/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Mauri-Laptop
 */
public class SpecialBinaryString {

    void test() {
        System.out.println(makeLargestSpecial("111000"));
    }

    public String makeLargestSpecial(String S) {
        if (S.length() == 2) {
            return "10";
        }
        Set<String> lst = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compare = o1.compareTo(o2);
                if (compare == 0) {
                    return 1;
                } else{
                    if (compare == -1) {
                        return 1;
                    }
                    return -1;
                }
            }
        });
        int cant1 = 0;
        int cant0 = 0;
        int posInit = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                cant1++;
            } else {
                cant0++;
            }
            if (cant1 - cant0 == 0) {
                String aux;
                aux = S.substring(posInit + 1, i);

                lst.add("1" + makeLargestSpecial(aux) + "0");
                posInit = i + 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (String s : lst) {
            res.append(s);
        }
        return res.toString();
    }

}
