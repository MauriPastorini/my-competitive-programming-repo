/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
public class GroupAnagrams {

    void test() {
        String[] strs = {"hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve", "elf", "pup", "bum", "iva", "lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen", "job", "dis", "max", "oho", "jed", "lye", "ram", "pup", "qua", "ugh", "mir", "nap", "deb", "hog", "let", "gym", "bye", "lon", "aft", "eel", "sol", "jab"};
        List<List<String>> st = groupAnagrams(strs);
        System.out.println("test");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lst = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lst;
        }
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String s : strs) {
            Map<Character, Integer> mapChars = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                mapChars.put(s.charAt(i), mapChars.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (!map.containsKey(mapChars)) {
                List<String> lAux = new ArrayList<>();
                lst.add(lAux);
                map.put(mapChars, lAux);
            }
            List<String> lstAux = map.get(mapChars);
            lstAux.add(s);
        }
        return lst;
    }
}
