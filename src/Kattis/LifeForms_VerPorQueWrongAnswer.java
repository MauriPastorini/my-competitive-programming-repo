package Kattis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LifeForms_VerPorQueWrongAnswer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (true) {
            if (input.equals("0")) {
                break;
            }
            int cant = Integer.parseInt(input);
            int half = cant / 2;
            StringBuilder strbuild = new StringBuilder();
            int separator = 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < cant; i++) {
                String word = in.nextLine();
                for (int j = 0; j < word.length(); j++) {
                    map.put(strbuild.length() + j, i);
                }
                strbuild.append(word);
                if (i != cant - 1) {
                    strbuild.append(separator);
                    separator++;
                }
            }
            String wordCont = strbuild.toString();
            int[] sa = suffixArray(strbuild.toString());
            int[] lcp = lcp(sa, wordCont);

            int actual = 0;
            int mid = cant / 2;
            Set<Integer> set = new TreeSet<>();
            int maxString = 0;
            Set<String> sol = new TreeSet<>();
            for (int i = 0; i < lcp.length; i++) {
                if (lcp[i] != 0 && lcp[i] == lcp[actual]) {
                    set.add(map.get(sa[i]));
                } else {
                    if (set.size() > mid) {
                        if (lcp[actual] >= maxString) {
                            if (lcp[actual] != maxString) {
                                sol = new TreeSet<>();
                            }
                            maxString = lcp[actual];
                            sol.add(wordCont.substring(sa[actual], sa[actual] + lcp[actual]));
                        }
                    }
                    set = new HashSet<>();
                    if (lcp[i] != 0) {
                        set.add(map.get(sa[i]));
                        set.add(map.get(sa[i - 1]));
                    }
                    actual = i;
                }
            }
            if (set.size() > mid) {
                if (lcp[actual] >= maxString) {
                    if (lcp[actual] != maxString) {
                        sol = new TreeSet<>();
                    }
                    sol.add(wordCont.substring(sa[actual], sa[actual] + lcp[actual]));
                }
            }
            if (sol.isEmpty()) {
                System.out.println("?");
            } else {
                for (String string : sol) {
                    System.out.println(string);
                }
            }
            input = in.nextLine();
            if (!input.equals("0")) {
                System.out.println("");
            }
        }
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
//        while (true) {
//            if (input.equals("0")) {
//                break;
//            }
//            int cant = Integer.parseInt(input);
//            int half = cant / 2;
//            StringBuilder strbuild = new StringBuilder();
//            int separator = 1;
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < cant; i++) {
//                String word = in.nextLine();
//                for (int j = 0; j < word.length(); j++) {
//                    map.put(strbuild.length() + j, i);
//                }
//                strbuild.append(word);
//                if (i != cant - 1) {
//                    strbuild.append(separator);
//                    separator++;
//                }
//            }
//            String wordCont = strbuild.toString();
//            int[] sa = suffixArray(strbuild.toString());
//            int[] lcp = lcp(sa, wordCont);
//
//            int actual = 0;
//            int mid = cant / 2;
//            List<String> sol = new ArrayList<>();
//            Set<Integer> set = new HashSet<>();
//
//            int start = 0;
//            int end = lcp.length;
//            while (start < end) {
//                if (set.size() <= mid) {
//                    end++;
//                }
//            }
//
//            if (sol.isEmpty()) {
//                System.out.println("?");
//            } else {
//                for (String string : sol) {
//                    System.out.println(string);
//                }
//            }
//            input = in.nextLine();
//            if (!input.equals("0")) {
//                System.out.println("");
//            }
//        }
//    }

    // sort suffixes of S in O(n*log(n))
    public static int[] suffixArray(CharSequence S) {
        int n = S.length();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = n - 1 - i;
        }

        // stable sort of characters
        Arrays.sort(order, (a, b) -> Character.compare(S.charAt(a), S.charAt(b)));

        int[] sa = new int[n];
        int[] classes = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = order[i];
            classes[i] = S.charAt(i);
        }
        // sa[i] - suffix on i'th position after sorting by first len characters
        // classes[i] - equivalence class of the i'th suffix after sorting by first len characters

        for (int len = 1; len < n; len *= 2) {
            int[] c = classes.clone();
            for (int i = 0; i < n; i++) {
                // condition sa[i - 1] + len < n simulates 0-symbol at the end of the string
                // a separate class is created for each suffix followed by simulated 0-symbol
                classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]] && sa[i - 1] + len < n && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]] : i;
            }
            // Suffixes are already sorted by first len characters
            // Now sort suffixes by first len * 2 characters
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++) {
                cnt[i] = i;
            }
            int[] s = sa.clone();
            for (int i = 0; i < n; i++) {
                // s[i] - order of suffixes sorted by first len characters
                // (s[i] - len) - order of suffixes sorted only by second len characters
                int s1 = s[i] - len;
                // sort only suffixes of length > len, others are already sorted
                if (s1 >= 0) {
                    sa[cnt[classes[s1]]++] = s1;
                }
            }
        }
        return sa;
    }

    // longest common prefixes array in O(n)
    public static int[] lcp(int[] sa, CharSequence s) {
        int n = sa.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }
        int[] lcp = new int[n];
        for (int i = 0, h = 0; i < n; i++) {
            if (rank[i] < n - 1) {
                for (int j = sa[rank[i] + 1]; Math.max(i, j) + h < s.length() && s.charAt(i + h) == s.charAt(j + h); ++h);
                lcp[rank[i] + 1] = h;
                if (h > 0) {
                    --h;
                }
            }
        }
        return lcp;
    }
}
