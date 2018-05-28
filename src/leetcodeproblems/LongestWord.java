/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mauri-Laptop
 */
public class LongestWord {

    class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;

        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    public void test() {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words3 = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};

        System.out.println(longestWord(words3));
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            TrieNode actualRoot = root;
            for (int j = 0; j < word.length; j++) {
                if (!actualRoot.children.containsKey(word[j])) {
                    actualRoot.children.put(word[j], new TrieNode());
                }
                actualRoot = actualRoot.children.get(word[j]);
            }
            actualRoot.endOfWord = true;
        }
        String maxWord = "";
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            TrieNode actualRoot = root;
            boolean possible = true;
            for (int j = 0; j < word.length && possible; j++) {
                if (!actualRoot.children.containsKey(word[j]) || !actualRoot.children.get(word[j]).endOfWord) {
                    possible = false;
                } else {
                    actualRoot = actualRoot.children.get(word[j]);
                }
            }
            if (possible) {
                if (word.length >= maxWord.length()) {
                    if (word.length == maxWord.length() && maxWord.compareTo(words[i]) < 0) {
                        maxWord = maxWord;
                    } else {
                        maxWord = words[i];
                    }
                }
            }
            actualRoot.endOfWord = true;
        }
        return maxWord.length() > 0 ? maxWord : null;
    }
}
