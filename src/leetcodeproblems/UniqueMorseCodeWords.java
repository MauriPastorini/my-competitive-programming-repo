/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
public class UniqueMorseCodeWords {

    public void test() {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        String[] keys = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Map<Character, String> map = new HashMap<>();

        char c = 'a';
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            map.put(c++, key);
        }

        Set<String> keysSet = new HashSet<>();
        for (String word : words) {
            char[] wodC = word.toCharArray();
            StringBuilder strBuild = new StringBuilder();
            for (int i = 0; i < wodC.length; i++) {
                char d = wodC[i];
                strBuild.append(map.get(d));
            }
            keysSet.add(strBuild.toString());
        }
        return keysSet.size();
    }
}
