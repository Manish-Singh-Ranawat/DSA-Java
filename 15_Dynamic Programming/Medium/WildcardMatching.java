// Wildcard Matching - https://leetcode.com/problems/wildcard-matching/description/

// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

import java.util.Arrays;

public class WildcardMatching {
    // -- Tabulation with Space Optimization --
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            dp[j] = true;
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    dp[j] = false;
                    break;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            boolean[] temp = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    temp[j] = dp[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    temp[j] = temp[j - 1] || dp[j];
                }
            }
            dp = temp;
        }
        return dp[n];
    }

    // -- Memoization --
    // public static boolean isMatch(String s, String p) {
    //     int m = s.length();
    //     int n = p.length();
    //     int[][] dp = new int[m + 1][n + 1];
    //     for (int i = 0; i <= m; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(m, n, s, p, dp) == 1;
    // }

    // private static int helper(int i, int j, String s, String p, int[][] dp) {
    //     if (i == 0 && j == 0)
    //         return 1;
    //     if (j == 0 && i > 0)
    //         return 0;
    //     if (i == 0 && j > 0) {
    //         for (int k = 1; k <= j; k++) {
    //             if (p.charAt(k - 1) != '*')
    //                 return 0;
    //         }
    //         return 1;
    //     }
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
    //         return dp[i][j] = helper(i - 1, j - 1, s, p, dp);
    //     }
    //     if (p.charAt(j - 1) == '*') {
    //         return dp[i][j] = helper(i, j - 1, s, p, dp) | helper(i - 1, j, s, p, dp);
    //     }
    //     return dp[i][j] = 0;
    // }

    public static void main(String[] args) {
        String s = "cb";
        String p = "?a";
        System.out.println(isMatch(s, p));
        // false
    }
}
