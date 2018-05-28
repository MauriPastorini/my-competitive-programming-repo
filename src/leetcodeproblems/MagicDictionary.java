/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;

/**
 *
 * @author Mauri-Laptop
 */
public class MagicDictionary {

    void test() {
        MagicDictionary m = new MagicDictionary();
        String[] dict = {"hello", "hallo", "leetocde"};
        m.buildDict(dict);
        System.out.println(m.search("hello"));
        System.out.println(m.search("hhllo"));
        System.out.println(m.search(""));
        System.out.println(m.search("leetcoded"));
        System.out.println("");
        m = new MagicDictionary();
        String[] dict2 = {"hille", "hello"};
        m.buildDict(dict2);
        System.out.println(m.search("leetcoda"));
        System.out.println(m.search("hhlle"));

    }

    class Dic {

        HashMap<Character, Dic> map;
        boolean isAWord;

        public Dic() {
            isAWord = false;
            map = new HashMap<>();
        }

        private void add(String s) {
            if (s.isEmpty() || s == null) {
                this.isAWord = true;
                return;
            }
            int i = 0;
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new Dic());
            }
            map.get(s.charAt(i)).add(s.substring(i + 1));
        }

        private boolean hasWord(String subSearch) {
            if (subSearch.isEmpty() || subSearch == null) {
                return this.isAWord;
            }
            if (this.map.containsKey(subSearch.charAt(0))) {
                return map.get(subSearch.charAt(0)).hasWord(subSearch.substring(1));
            } else {
                return false;
            }
        }

    }

    Dic dic;

    public MagicDictionary() {
        dic = new Dic();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            dic.add(s);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word
     * after modifying exactly one character
     */
    public boolean search(String word) {
        int pos = 0;
        Dic root = dic;
        while (pos < word.length()) {
            char c = word.charAt(pos);
            if (root.map.containsKey(c)) {
                root = root.map.get(c);
            } else {
                break;
            }
            pos++;
        }
        if (pos == word.length()) {
            return false;
        }
        String subSearch = word.substring(pos + 1);
        boolean hasWord = false;
        for (Dic dic : root.map.values()) {
            hasWord = dic.hasWord(subSearch);
            if (hasWord) {
                return true;
            }
        }
        return false;
    }
}
