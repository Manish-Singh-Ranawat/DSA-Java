// Minimum Window Subsequence - https://www.naukri.com/code360/problems/minimum-window-subsequence_2181133?leftPanelTabValue=PROBLEM

// You are given two strings ‘S’ and ‘T’. Your task is to find the minimum (Contiguous) substring ‘W’ of ‘S’, such that ‘T’ is a subsequence of ‘W’

// A subsequence is a sequence that can be derived from another sequence by removing zero or more elements, without changing the order.

// A substring is a contiguous part of a string.

// For example:
// For the given string “CodingNinjas”: “Ninja” is a substring while “dinas” is a subsequence. 
// If there is no such Window in ‘S’ that covers all characters in ‘T’, return an empty string "". If there are multiple such minimum length windows, return the one with the smallest starting index.

// Input: S = "abcdebdde" , T = "bde"
// Output: "bcde"
// Explanation: “bcde” is the substring of minimum length in which we find “bde”. “bdde” is also a substring of minimum length however the index of “bcde” occurs first, therefore we returned "bcde"

public class MinimumWindowSubsequence {
    public static String minWindow(String S, String T) {
        int l = 0;
        int r = 0;
        int k = 0;
        int sLen = S.length();
        int tLen = T.length();
        String substring = "";
        int minLen = Integer.MAX_VALUE;
        while (r < sLen && k < tLen) {
            if (S.charAt(r) == T.charAt(k)) {
                k++;
            }
            if (k == tLen) {
                k--;
                l = r;
                while (k >= 0 && l >= 0) {
                    if (S.charAt(l) == T.charAt(k)) {
                        k--;
                    }
                    l--;
                }
                l++;
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    substring = S.substring(l, r + 1);
                }
                k = 0;
                r = l;
            }
            r++;
        }
        return substring;
    }

    public static void main(String[] args) {
        String S = "abcdebdde";
        String T = "bde";
        System.out.println(minWindow(S, T));
        // bcde
    }
}
