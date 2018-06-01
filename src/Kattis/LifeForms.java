package Kattis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LifeForms {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = Integer.parseInt(in.nextLine());
        while (true) {
            int n = cant;
            String[] words = new String[cant];
            while (cant-- != 0) {
                words[n - cant - 1] = in.nextLine();
            }
            char separator = '$';
            StringBuilder strBuild = new StringBuilder();
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char[] cs = words[i].toCharArray();
                for (int j = 0; j < words[i].length(); j++) {
                    map.put(strBuild.length(), words[i] + separator);
                    strBuild.append(cs[j]);
                }
                map.put(strBuild.length(), words[i] + separator);
                strBuild.append(separator++);
            }
            int condOfEqual = n / 2 + 1;

            int[] sa = suffixArray(strBuild.toString());
            int[] lcp = lcp(sa, strBuild.toString());

            Set<String> lst = maxSlidingWindow(strBuild.toString(), sa, lcp, condOfEqual, map, n);

            if (lst.isEmpty()) {
                System.out.println("?");
            } else {
                for (String string : lst) {
                    System.out.println(string);
                }
            }
            cant = Integer.parseInt(in.nextLine());
            if (cant == 0) {
                break;
            } else{
                System.out.println("");
            }
        }
    }

    public static Set<String> maxSlidingWindow(String wordConcat, int[] sa, int[] lcp, int minWords, Map<Integer, String> mapWordInPos, int cantDifWords) {
        Set<String> lst = new TreeSet<>();
        List<Integer> lstAux = new ArrayList<>();
        if (lcp == null || minWords <= 0) {
            return lst;
        }
        int n = lcp.length;
        Map<String, Integer> wordsInWindow = new HashMap<>();

        // store index
        Deque<Integer> q = new ArrayDeque<>();
        int start = cantDifWords;
        int end = cantDifWords;
        int minIndex = -1;
        int newIndex = start;
        boolean startMoved = false;
        while (start < lcp.length) {
            if (!startMoved) {
                updateMapWordsInWindow(true, sa[newIndex], mapWordInPos, wordsInWindow);
            }
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() <= start) {
                q.poll();
            }
            // remove grater numbers in k range as they are useless
            while (!q.isEmpty() && newIndex == end && lcp[q.peekLast()] > lcp[newIndex]) {
                q.pollLast();
            }
            // q contains index... r contains content
            if (!startMoved && lcp[newIndex] != 0) {
                q.offer(newIndex);
            }
            if (wordsInWindow.size() >= minWords) {
                if (!q.isEmpty()) {
                    if (minIndex == -1 || lcp[q.peek()] >= lcp[minIndex]) {
                        if (minIndex == -1 || lcp[q.peek()] > lcp[minIndex]) {
                            lstAux = new ArrayList<>();
                        }
                        minIndex = q.peek();
                        lstAux.add(minIndex);
                    }
                }
            }
            if (wordsInWindow.size() < minWords) {
                end++;
                newIndex = end;
                startMoved = false;
            }
            if (wordsInWindow.size() >= minWords || end >= lcp.length) {
                updateMapWordsInWindow(false, sa[start], mapWordInPos, wordsInWindow);
                start++;
                newIndex = start;
                startMoved = true;
            }
        }
        for (Integer i : lstAux) {
            lst.add(wordConcat.substring(sa[i], sa[i] + lcp[i]));
        }
        return lst;
    }

    private static void updateMapWordsInWindow(boolean isAdding, int i, Map<Integer, String> mapWordInPos, Map<String, Integer> wordsInWindow) {
        String word = mapWordInPos.get(i);
        if (isAdding) {
            wordsInWindow.put(word, wordsInWindow.getOrDefault(word, 0) + 1);
        } else {
            if (wordsInWindow.get(word) == 1) {
                wordsInWindow.remove(word);
            } else {
                wordsInWindow.put(word, wordsInWindow.get(word) - 1);
            }
        }
    }

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
