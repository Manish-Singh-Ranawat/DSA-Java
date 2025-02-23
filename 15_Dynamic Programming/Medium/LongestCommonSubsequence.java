// Longest Common Subsequence - https://leetcode.com/problems/longest-common-subsequence/description/

// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

import java.util.Arrays;

public class LongestCommonSubsequence {
    // -- Tabulation with Space Optimization --
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    temp[j] = 1 + dp[j - 1];
                else
                    temp[j] = Math.max(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[n];
    }

    // -- Memoization --
    // public static int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length();
    //     int n = text2.length();
    //     int[][] dp = new int[m + 1][n + 1];
    //     for (int i = 0; i <= m; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(m, n, text1, text2, dp);
    // }

    // private static int helper(int i, int j, String text1, String text2, int[][] dp) {
    //     if (i == 0 || j == 0)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     if (text1.charAt(i - 1) == text2.charAt(j - 1))
    //         return dp[i][j] = 1 + helper(i - 1, j - 1, text1, text2, dp);
    //     return dp[i][j] = Math.max(helper(i - 1, j, text1, text2, dp), helper(i, j - 1, text1, text2, dp));
    // }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        // 3
    }
}
