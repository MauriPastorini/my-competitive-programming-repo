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
public class MagicDictionary2 {

    void test() {
        MagicDictionary2 m = new MagicDictionary2();
        String[] dict = {"hello", "hallo", "leetocde"};
        m.buildDict(dict);
        System.out.println(m.search("hello"));
        System.out.println(m.search("hhllo"));
        System.out.println(m.search("hell"));
        System.out.println(m.search("leetcoded"));
        System.out.println("");
        m = new MagicDictionary2();
        String[] dict2 = {"hille", "hello"};
        m.buildDict(dict2);
        System.out.println(m.search("leetcoda"));
        System.out.println(m.search("hhlle"));

    }

    Set<String> set;

    public MagicDictionary2() {
        set = new HashSet<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            set.add(s);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word
     * after modifying exactly one character
     */
    public boolean search(String word) {
        for (String s : set) {
            if (s.length() == word.length()) {
                if (checkDifOne(s, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDifOne(String s, String word) {
        int cant = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != word.charAt(i)) {
                cant++;
                if (cant > 1) {
                    return false;
                }
            }
        }
        if (cant == 0) {
            return false;
        }
        return true;
    }
}
