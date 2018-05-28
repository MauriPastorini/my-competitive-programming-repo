/*
Algorithm took from LeetCode https://leetcode.com/problems/longest-common-prefix/solution/
 */
package Strings.Problems;

public class LongestCommonPrefix {

    //Option 1: Vertical Scanning
    /*
        Time complexity : O(S) , where S is the sum of all characters in all strings. 
        In the worst case there will be n equal strings with length m and the algorithm performs S = m*n character comparisons. 
        Even though the worst case is still the same as Approach #1, in the best case there are at most n*minLen comparisons where minLen is the length of the shortest string in the array.
        *Space complexity : O(1). We only used constant extra space.
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // Option 2: Binary Search
    /*
        In the worst case we have n equal strings with length m
        Time complexity : O(S*log(n), where SS is the sum of all characters in all strings.
        The algorithm makes log(n) iterations, for each of them there are S = m*n comparisons, which gives in total O(S∗log(n)) time complexity.

        Space complexity : O(1)
        We only used constant extra space.
    */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }
}
