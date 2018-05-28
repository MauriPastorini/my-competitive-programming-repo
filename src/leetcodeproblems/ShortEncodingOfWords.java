/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import datastructures.TrieSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
public class ShortEncodingOfWords {

    void test() {
        String[] words = {"time", "time", "time"};
        System.out.println(minimumLengthEncodingTrie(words));
    }

    public int minimumLengthEncodingTrie(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        TrieSimple root = new TrieSimple();
        int res = 0;
        Set<TrieSimple> leaves = new HashSet<>();
        for(String s : words){
            TrieSimple node = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                node.add(s.charAt(i));
                node = node.next.get(s.charAt(i));
            }
            leaves.add(node);
        }
        for(TrieSimple t : leaves){
            if (t.next.isEmpty()) {
                res += t.depth + 1;
            }
        }
        return res;
    }

    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        String[] wordsC = words.clone();
        Arrays.sort(wordsC, (a, b) -> Integer.compare(b.length(), a.length()));

        String res = wordsC[0] + "#";
        for (int i = 1; i < wordsC.length; i++) {
            if (!res.contains(wordsC[i] + "#")) {
                res = res + wordsC[i] + "#";
            }
        }
        return res.length();
    }
}
