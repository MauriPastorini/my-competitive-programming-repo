package Strings.Problems;

public class LongestCommonSubstring {

    /* 
       USING DYNAMIC PROGRAMMING (Can be implemented With Suffix Tree Also)
       Returns length of longest common substring  
       of X[0..m-1] and Y[0..n-1] 
     */
    static String LCSubStr(char X[], char Y[], int m, int n) {
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that LCSuff[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
        // first column entries have no logical meaning, they are used only
        // for simplicity of program
        int LCStuff[][] = new int[m + 1][n + 1];
        int result = 0;  // To store length of the longest common substring
        int maxI = 0;
        int maxJ = 0;
        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    LCStuff[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    if (result < LCStuff[i][j]) {
                        result = LCStuff[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                } else {
                    LCStuff[i][j] = 0;
                }
            }
        }
        StringBuilder strB = new StringBuilder();
        int posOfMax = result;
        while (posOfMax > 0 && maxI >= 0 && maxJ >= 0) {
            strB.insert(0, X[maxI - 1]);
            maxI--;
            maxJ--;
            posOfMax = LCStuff[maxI][maxJ];
        }
        return strB.toString();
    }

    /*
    * Algoritmo para varios substring. 
    * NO LO PROBE MUCHO Y LO SAQUE DE STACK OVERFLOW: https://stackoverflow.com/questions/17150311/java-implementation-for-longest-common-substring-of-n-strings
    * No se el Orden. Si fuese DP seria O(NxN2x.....NM). Los suffix tree son O(N+N2+....+NM)
     */
    public static String identifyCommonSubStrOfNStr(String[] strArr) {

        String commonStr = "";
        String smallStr = "";

        //identify smallest String      
        for (String s : strArr) {
            if (smallStr.length() < s.length()) {
                smallStr = s;
            }
        }

        String tempCom = "";
        char[] smallStrChars = smallStr.toCharArray();
        for (char c : smallStrChars) {
            tempCom += c;

            for (String s : strArr) {
                if (!s.contains(tempCom)) {
                    tempCom = c + "";
                    for (String s2 : strArr) {
                        if (!s2.contains(tempCom)) {
                            tempCom = "";
                            break;
                        }
                    }
                    break;
                }
            }

            if (tempCom != "" && tempCom.length() > commonStr.length()) {
                commonStr = tempCom;
            }
        }

        return commonStr;
    }

    public static void main(String[] args) {
        String X = "--a.txt";
        String Y = "--ba.txt";
        String Z = "--ca.twe";

        String[] st = {X, Y, Z};
        String intersection = identifyCommonSubStrOfNStr(st);
        System.out.print("Intersection: ");
        System.out.println(intersection);

        int m = X.length();
        int n = Y.length();

        System.out.println("Longest Common Substring is "
                + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
    }
}
