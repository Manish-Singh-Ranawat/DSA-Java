// Longest Palindromic Subsequence - https://leetcode.com/problems/longest-palindromic-subsequence/

// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, r);
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    temp[j] = 1 + dp[j - 1];
                else
                    temp[j] = Math.max(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
        // 4
    }
}
