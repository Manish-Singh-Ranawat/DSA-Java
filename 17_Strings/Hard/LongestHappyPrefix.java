// Longest Happy Prefix - https://leetcode.com/problems/longest-happy-prefix/description/

// A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

// Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

// Input: s = "ababab"
// Output: "abab"
// Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.

import java.util.Arrays;

public class LongestHappyPrefix {
    public static String longestPrefix(String s) {
        int n = s.length();
        int[] lps = computeLPS(s);
        int max = Integer.MIN_VALUE;
        return s.substring(0, lps[n - 1]);
    }

    private static int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(longestPrefix(s));
        // abab
    }
}
