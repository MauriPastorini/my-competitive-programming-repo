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
public class AmbiguosCoordinates {

    public void test() {
        List<String> d = ambiguousCoordinates("(100)");
        for (String x : d) {
            System.out.println(x);
        }
    }

    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList();
        for (int i = 2; i < S.length() - 1; ++i) {
            for (String left : make(S, 1, i)) {
                for (String right : make(S, i, S.length() - 1)) {
                    ans.add("(" + left + ", " + right + ")");
                }
            }
        }
        return ans;
    }

    public List<String> make(String S, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j - i; ++d) {
            String left = S.substring(i, i + d);
            String right = S.substring(i + d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0")) {
                ans.add(left + (d < j - i ? "." : "") + right);
            }
        }
        return ans;
    }

    public List<String> ambiguousCoordinates_Mauri(String S) {
        if (S == null || S.equals("")) {
            return null;
        }
        S = S.substring(1, S.length() - 1);
        char[] elem = S.toCharArray();
        List<String> lst = new ArrayList<>();

        for (int i = 0; i < elem.length - 1; i++) {
            List<String> left = addPossibilities(0, i, elem, S);
            if (left.size() > 0) {
                List<String> right = addPossibilities(i + 1, elem.length - 1, elem, S);
                List<String> res = mergeLst(left, right);
                lst.addAll(res);
            }

        }
        return lst;
    }

    private List<String> addPossibilities(int i, int f, char[] elem, String S) {
        List<String> lst = new ArrayList<>();
        if (elem[i] == '0') {
            if (f > i) {
                int pos = i + 1;
                String opt = "0.";
                while (pos <= f) {
                    opt += elem[pos];
                    pos++;
                }
                if (elem[pos - 1] == '0') {
                    return lst;
                }
                lst.add(opt);
                return lst;
            } else {
                String opt1 = "0";
                lst.add(opt1);
                return lst;
            }
        } else {
            lst.add(S.substring(i, f + 1));
            String opt = elem[i] + "";
            int pos = i + 1;
            while (pos <= f) {
                opt = S.substring(i, pos) + ".";
                String optFin = opt + S.substring(pos, f + 1);
                if (optFin.charAt(optFin.length() - 1) != '0') {
                    lst.add(optFin);
                }
                pos++;
            }
            return lst;
        }
    }

    private List<String> mergeLst(List<String> left, List<String> right) {
        List<String> res = new ArrayList<>();
        for (String l : left) {
            for (String r : right) {
                res.add("(" + l + ", " + r + ")");
            }
        }
        return res;
    }
}
