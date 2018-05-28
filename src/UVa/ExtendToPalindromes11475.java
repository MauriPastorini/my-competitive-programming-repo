package UVa;

import java.util.Arrays;
import java.util.Scanner;

public class ExtendToPalindromes11475 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                break;
            }
            StringBuilder strBuild = new StringBuilder(line);
            String reverse = strBuild.reverse().toString();
            strBuild.append(line);
            int[] border = new int[strBuild.length()];
            computeLPSArray(strBuild.toString(), strBuild.length(), border);
            String res = border[border.length - 1] < reverse.length() ? line + reverse.substring(border[border.length - 1]) : line;
            System.out.println(res);
        }
    }

    static void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
