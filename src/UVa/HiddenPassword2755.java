/*
 * ACM 2755: Hidden Password. Exercie from suffix array paper
 * NO LO HICE ANDAR CON SUFFIX ARRAY
 */
package UVa;

import java.util.Arrays;
import java.util.Scanner;

public class HiddenPassword2755 {

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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = Integer.parseInt(in.nextLine());
        while (cant-- > 0) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] aux = line.split(" ");
            if (aux.length < 2) {
                System.out.println("0");
                continue;
            }
            String word = aux[1];
            String conc = word + word;
            int[] sa = suffixArray(conc);

            int n = word.length();
            String sol = "";
            for (int i = 0; i < sa.length; i++) {
                if (sol.isEmpty() && sa[i] < n) {
                    sol = conc.substring(sa[i], sa[i] + word.length());
                    break;
                }
            }
            System.out.println(conc.indexOf(sol));
        }
    }
}
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int cant = Integer.parseInt(in.nextLine());
//        for (int i = 0; i < cant; i++) {
//            String line = in.nextLine();
//            String[] arg = line.split(" ");
//            if (arg.length == 2) {
//                String word = arg[1] + arg[1];
//                int pos = 0;
//                int posSol = 0;
//                String solution = "";
//                boolean notFound = true;
//                while (notFound && pos < sufArray.length()) {
//                    String actualWord = word.substring(sufArray.index(pos));
//                    if (actualWord.length() >= arg[1].length()) {
//                        actualWord = actualWord.substring(0, arg[1].length());
//                        if (!solution.isEmpty()) {
//                            if (solution.equals(actualWord)) {
//                                posSol = Integer.min(posSol, sufArray.index(pos));
//                            } else {
//                                notFound = false;
//                            }
//                        } else {
//                            solution = actualWord;
//                            posSol = sufArray.index(pos);
//                        }
//                    } else {
//                        if (!solution.isEmpty()) {
//                            notFound = false;
//                        }
//                    }
//                    pos++;
//                }
//                System.out.println(posSol);
//            } else {
//                System.out.println("");
//            }
//        }
//    }
//}
