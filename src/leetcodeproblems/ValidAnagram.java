/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
public class ValidAnagram {

    void test() {
        System.out.println(isAnagram("asd", "sad"));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            int val = map.getOrDefault(t.charAt(i), -1);
            if (val == -1) {
                return false;
            }
            if (val == 1) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        if (map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
