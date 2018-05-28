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
public class MostCommonWord {

    public void test() {
        String[] banned = {"hit"};
        System.out.println(mostCommonWord("Bob'", banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split(" ");

        Set<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }

        Set<Character> puntuation = new HashSet<>();
        puntuation.add('.');
        puntuation.add('!');
        puntuation.add('?');
        puntuation.add('\'');
        puntuation.add(',');
        puntuation.add(';');
        puntuation.add('.');
        for (int i = 0; i < words.length; i++) {
            String actualWord = words[i].trim().toLowerCase();
            if (puntuation.contains(actualWord.charAt(actualWord.length() - 1))) {
                actualWord = actualWord.substring(0, actualWord.length() - 1);
            }
            if (!set.contains(actualWord)) {
                map.put(actualWord, map.getOrDefault(actualWord, 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxWord = entry.getKey();
            }
        }
        return maxWord;
    }
}
