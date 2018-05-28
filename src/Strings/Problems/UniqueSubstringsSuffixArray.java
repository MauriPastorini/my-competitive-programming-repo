/*
    Count of distinct substrings of a string using Suffix Array
    Based on: https://www.geeksforgeeks.org/count-distinct-substrings-string-using-suffix-trie/
    
    Example:
    Input  : str = “ababa”
    Output : 10
    Total number of distinct substring are 10, which are,
    "", "a", "b", "ab", "ba", "aba", "bab", "abab", "baba"
    and "ababa"
 */
package Strings.Problems;

import datastructures.SuffixLCPArray;
import java.util.ArrayList;
import java.util.List;

public class UniqueSubstringsSuffixArray {

    private static List<String> uniqueSubstrings(String str) {
        int[] suffixArray = SuffixLCPArray.suffixArray(str);
        int[] lcp = SuffixLCPArray.lcp(suffixArray, str);
        List<String> lst = new ArrayList<>();
        lst.add("");
        int n = str.length();
        int result = n - suffixArray[0];
        for (int j = 0; j < result; j++) {
            lst.add(str.substring(suffixArray[0], suffixArray[0] + j + 1));
        }
        for (int i = 1; i < suffixArray.length; i++) {
            int cant = n - suffixArray[i] - lcp[i - 1];
            result += cant;
            for (int j = 0; j < cant; j++) {
                lst.add(str.substring(suffixArray[i], suffixArray[i] + lcp[i - 1] + j + 1));
            }
        }
        result++; // Empty substring
        System.out.println(result);
        return lst;
    }

    public static void main(String[] args) {
        List<String> lst = uniqueSubstrings("AZAZA"); // Contando el vacio
        for (String string : lst) {
            System.out.println(string);
        }
    }
}
