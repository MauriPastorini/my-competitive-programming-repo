package UVa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DNASequencing760 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line1 = in.nextLine();
            String line2 = in.nextLine();
            if (in.hasNextLine()) {
                in.nextLine();
            }
            String lineCom = line1 + "#" + line2;
            int[] sa = suffixArray(lineCom);
            int[] lcp = lcp(sa, lineCom);

            List<String> lst = new ArrayList<>();
            int max = 0;
            for (int i = 1; i < lcp.length; i++) {
                if (lcp[i] != 0 && lcp[i] >= lcp[max]) {
                    boolean correctSubstring = false;
                    if (sa[i] < line1.length() && sa[i - 1] > line1.length()) {
                        correctSubstring = true;
                    } else if (sa[i-1] < line1.length() && sa[i] > line1.length()) {
                        correctSubstring = true;
                    }
                    if (correctSubstring) {
                        if (lcp[max] != lcp[i]) {
                            lst = new ArrayList<>();
                        }
                        String sub = lineCom.substring(sa[i], sa[i] + lcp[i]);
                        if (!lst.contains(sub)) {
                            lst.add(sub);
                        }
                        max = i;
                    }
                }
            }
            if (lst.isEmpty()) {
                System.out.println("No common sequence.");
            }else{
                for (String string : lst) {
                    System.out.println(string);
                }
            }
            if (in.hasNextLine()) {
                System.out.println("");
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
