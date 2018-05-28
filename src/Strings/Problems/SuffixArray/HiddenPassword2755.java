/*
 * ACM 2755: Hidden Password. Exercie from suffix array paper
 * NO LO HICE ANDAR CON SUFFIX ARRAY
 */
package Strings.Problems.SuffixArray;

import java.util.Arrays;
import java.util.Scanner;

public class HiddenPassword2755 {

    static class SuffixArray {

        private Suffix[] suffixes;

        /**
         * Initializes a suffix array for the given {@code text} string.
         *
         * @param text the input string
         */
        public SuffixArray(String text) {
            int n = text.length();
            this.suffixes = new Suffix[n];
            for (int i = 0; i < n; i++) {
                suffixes[i] = new Suffix(text, i);
            }
            Arrays.sort(suffixes);
        }

        private class Suffix implements Comparable<Suffix> {

            private final String text;
            private final int index;

            private Suffix(String text, int index) {
                this.text = text;
                this.index = index;
            }

            private int length() {
                return text.length() - index;
            }

            private char charAt(int i) {
                return text.charAt(index + i);
            }

            public int compareTo(Suffix that) {
                if (this == that) {
                    return 0;  // optimization
                }
                int n = Math.min(this.length(), that.length());
                for (int i = 0; i < n; i++) {
                    if (this.charAt(i) < that.charAt(i)) {
                        return -1;
                    }
                    if (this.charAt(i) > that.charAt(i)) {
                        return +1;
                    }
                }
                return this.length() - that.length();
            }

            public String toString() {
                return text.substring(index);
            }
        }

        /**
         * Returns the length of the input string.
         *
         * @return the length of the input string
         */
        public int length() {
            return suffixes.length;
        }

        /**
         * Returns the index into the original string of the <em>i</em>th
         * smallest suffix. That is, {@code text.substring(sa.index(i))} is the
         * <em>i</em>th smallest suffix.
         *
         * @param i an integer between 0 and <em>n</em>-1
         * @return the index into the original string of the <em>i</em>th
         * smallest suffix
         * @throws java.lang.IllegalArgumentException unless {@code 0 <= i < n}
         */
        public int index(int i) {
            if (i < 0 || i >= suffixes.length) {
                throw new IllegalArgumentException();
            }
            return suffixes[i].index;
        }

        /**
         * Returns the length of the longest common prefix of the <em>i</em>th
         * smallest suffix and the <em>i</em>-1st smallest suffix.
         *
         * @param i an integer between 1 and <em>n</em>-1
         * @return the length of the longest common prefix of the <em>i</em>th
         * smallest suffix and the <em>i</em>-1st smallest suffix.
         * @throws java.lang.IllegalArgumentException unless {@code 1 <= i < n}
         */
        public int lcp(int i) {
            if (i < 1 || i >= suffixes.length) {
                throw new IllegalArgumentException();
            }
            return lcpSuffix(suffixes[i], suffixes[i - 1]);
        }

        // longest common prefix of s and t
        int lcpSuffix(Suffix s, Suffix t) {
            int n = Math.min(s.length(), t.length());
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return i;
                }
            }
            return n;
        }

        /**
         * Returns the <em>i</em>th smallest suffix as a string.
         *
         * @param i the index
         * @return the <em>i</em> smallest suffix as a string
         * @throws java.lang.IllegalArgumentException unless {@code 0 <= i < n}
         */
        public String select(int i) {
            if (i < 0 || i >= suffixes.length) {
                throw new IllegalArgumentException();
            }
            return suffixes[i].toString();
        }

        /**
         * Returns the number of suffixes strictly less than the {@code query}
         * string. We note that {@code rank(select(i))} equals {@code i} for
         * each {@code i} between 0 and <em>n</em>-1.
         *
         * @param query the query string
         * @return the number of suffixes strictly less than {@code query}
         */
        public int rank(String query) {
            int lo = 0, hi = suffixes.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int cmp = compare(query, suffixes[mid]);
                if (cmp < 0) {
                    hi = mid - 1;
                } else if (cmp > 0) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
            return lo;
        }

        // compare query string to suffix
        private int compare(String query, Suffix suffix) {
            int n = Math.min(query.length(), suffix.length());
            for (int i = 0; i < n; i++) {
                if (query.charAt(i) < suffix.charAt(i)) {
                    return -1;
                }
                if (query.charAt(i) > suffix.charAt(i)) {
                    return +1;
                }
            }
            return query.length() - suffix.length();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = Integer.parseInt(in.nextLine());
        for (int i = 0; i < cant; i++) {
            String line = in.nextLine();
            String[] arg = line.split(" ");
            if (arg.length == 2) {
                String word = arg[1] + arg[1];
                SuffixArray sufArray = new SuffixArray(word);
                int pos = 0;
                int posSol = 0;
                String solution = "";
                boolean notFound = true;
                while (notFound && pos < sufArray.length()) {
                    String actualWord = word.substring(sufArray.index(pos));
                    if (actualWord.length() >= arg[1].length()) {
                        actualWord = actualWord.substring(0, arg[1].length());
                        if (!solution.isEmpty()) {
                            if (solution.equals(actualWord)) {
                                posSol = Integer.min(posSol, sufArray.index(pos));
                            } else {
                                notFound = false;
                            }
                        } else {
                            solution = actualWord;
                            posSol = sufArray.index(pos);
                        }
                    } else {
                        if (!solution.isEmpty()) {
                            notFound = false;
                        }
                    }
                    pos++;
                }
                System.out.println(posSol);
            } else {
                System.out.println("");
            }
        }
    }
}
