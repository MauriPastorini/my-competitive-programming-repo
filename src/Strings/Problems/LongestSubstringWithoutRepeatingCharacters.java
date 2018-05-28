/*
    Code based in my solution: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */
package Strings.Problems;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int left = 0;
        int right = 1;
        String max = s.substring(left, right);
        String curr = s.substring(left, right);
        while (right < s.length()) {
            if (curr.indexOf(s.charAt(right)) == -1) {
                right++;
            } else {
                left = left + curr.indexOf(s.charAt(right)) + 1;
                right++;
            }
            curr = s.substring(left, right);
            max = max.length() > curr.length() ? max : curr;
        }
        return max.length();
    }

    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.println("The input string is " + str);
        int len = lengthOfLongestSubstring(str);
        System.out.println("The length of "
                + "the longest non repeating character is " + len);
    }
}
