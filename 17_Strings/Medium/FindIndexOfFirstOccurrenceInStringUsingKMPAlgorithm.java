// Find the Index of the First Occurrence in a String - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.

public class FindIndexOfFirstOccurrenceInStringUsingKMPAlgorithm {
    public static int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    public static int kmp(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        int[] lps = computeLPS(pattern);
        int i = 0;
        int j = 0;
        while (i < m) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
            if (j == n)
                return i - n;
        }
        return -1;
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
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
        // 0
    }
}
