/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
//class Trie {
//
//    Map<Character, Trie> map = new HashMap<>();
//    boolean finalWord = false;
//
//    void add(String word) {
//        if (word.equals("")) {
//            this.finalWord = true;
//            return;
//        }
//        this.map.put(word.charAt(0), map.getOrDefault(word.charAt(0), new Trie()));
//        String sub = word.substring(1);
//        map.get(word.charAt(0)).add(word.substring(1));
//    }
//
//    int getCant(int level) {
//        int sum = 0;
//        if (this.finalWord) {
//            sum += level;
//        }
//        int cant;
//        if (!this.finalWord && map.size() == 1) {
//            cant = 0;
//        } else {
//            cant = 1;
//        }
//        for (Trie t : map.values()) {
//            sum += t.getCant(level + cant);
//        }
//        return sum;
//    }
//}
class Trie {

    Map<Character, Trie> map = new HashMap<>();
    boolean finalWord = false;

    void add(String word) {
        if (word.equals("")) {
            if (!finalWord) {
                finalWord = true;
                DiccionarioPortuñol5792.cant++;
            }

            return;
        }
        this.map.put(word.charAt(0), map.getOrDefault(word.charAt(0), new Trie()));
        String sub = word.substring(1);
        map.get(word.charAt(0)).add(word.substring(1));
    }
}

public class DiccionarioPortuñol5792 {

    static int cant = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String lineNum = in.nextLine();
            String[] nums = lineNum.split(" ");
            int a = Integer.parseInt(nums[0]), b = Integer.parseInt(nums[1]);
            cant = 0;
            if (a == 0 && b == 0) {
                break;
            }
            String[] wordsP = new String[a];
            for (int i = 0; i < a; i++) {
                wordsP[i] = in.nextLine();
            }
            String[] wordsQ = new String[b];
            for (int i = 0; i < b; i++) {
                wordsQ[i] = in.nextLine();
            }
            Trie trie = new Trie();

            for (int i = 0; i < a; i++) {
                String wordP = wordsP[i];
                for (int j = 1; j < wordP.length()+1; j++) {
                    String pref = wordP.substring(0, j);
                    for (int k = 0; k < wordsQ.length; k++) {
                        String wordQ = wordsQ[k];
                        for (int m = 0; m < wordQ.length(); m++) {
                            String pos = wordQ.substring(m, wordQ.length());
                            String wordToAdd = pref + pos;
                            trie.add(wordToAdd);
                        }
                    }
                }
            }

            System.out.println(cant);
        }
    }

    private static List<String> addPrefixes(String wordP) {
        List<String> prefs = new ArrayList<>();
        for (int i = wordP.length(); i >= 0; i--) {
            String pref = wordP.substring(0, i);

            prefs.add(pref);
        }
        return prefs;

    }

    private static List<String> makePostfixes(String wordQ) {
        List<String> sufixes = new ArrayList<>();
        for (int i = 0; i < wordQ.length(); i++) {
            String pref = wordQ.substring(i, wordQ.length());
            sufixes.add(pref);
        }
        sufixes.add("");
        return sufixes;
    }
}
