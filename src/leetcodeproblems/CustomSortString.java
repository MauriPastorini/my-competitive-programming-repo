package leetcodeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomSortString {

    public void test() {
        System.out.println(customSortString("cba", "abcdbca"));
    }

    public String customSortString(String S, String T) {
        char[] sAux = S.toCharArray();
        char[] tAux = T.toCharArray();
        int[] cantLet = new int[S.length()];

        Map<Character, Integer> cantChars = new LinkedHashMap<>();
        for (int i = 0; i < sAux.length; i++) {
            cantChars.put(sAux[i], 0);
        }
        for (int i = 0; i < tAux.length; i++) {
            if (cantChars.containsKey(tAux[i])) {
                cantChars.put(tAux[i], cantChars.get(tAux[i]) + 1);
            }
        }
        StringBuilder res = new StringBuilder();
        boolean keepSearching = true;
        int pos;
        for (pos = 0; pos < T.length() && keepSearching; pos++) {
            if (cantChars.containsKey(tAux[pos])) {
                res.append(T.substring(0, pos));
                keepSearching = false;
            }
        }
        for (Map.Entry<Character, Integer> entry : cantChars.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }
        for (int i = pos; i < T.length(); i++) {
            if (!cantChars.containsKey(tAux[i])) {
                res.append(tAux[i]);
            }
        }
        return res.toString();
    }

}
