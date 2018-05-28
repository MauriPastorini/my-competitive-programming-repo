package leetcodeproblems;

import java.util.Arrays;

public class NumberOfLinesToWriteString {

    public void test() {
//        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
//        int[] res = numberOfLines(widths, "bbbcccdddaaa");
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] res = numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(Arrays.toString(res));
    }

    public int[] numberOfLines(int[] widths, String S) {
        if (widths == null || widths.length == 0 || S == null || S.length() == 0) {
            int[] res = {0, 0};
            return res;
        }
        int max = 100;
        char[] word = S.toCharArray();
        int actual = 0;
        int linesNeed = 1;
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            int pos = c - 'a';
            int w = widths[pos];

            actual += w;
            if (actual > max) {
                linesNeed++;
                actual = w;
            }
        }
        int[] res = {linesNeed, actual};
        return res;
    }
}
