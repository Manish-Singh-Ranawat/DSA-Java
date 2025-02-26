// Distinct Subsequences - https://leetcode.com/problems/distinct-subsequences/description/

// Given two strings s and t, return the number of distinct subsequences of s which equals t.

// The test cases are generated so that the answer fits on a 32-bit signed integer.

// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from s.
// babgbag
// babgbag
// babgbag
// babgbag
// babgbag

import java.util.Arrays;

public class DistinctSubsequences {
    // -- Tabulation with Space Optimization --
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[n];
    }

    // -- Memoization --
    // public static int numDistinct(String s, String t) {
    //     int m = s.length();
    //     int n = t.length();
    //     int[][] dp = new int[m + 1][n + 1];
    //     for (int i = 0; i <= m; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(m, n, s, t, dp);
    // }

    // private static int helper(int i, int j, String s, String t, int[][] dp) {
    //     if (j == 0)
    //         return 1;
    //     if (i == 0)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     if (s.charAt(i - 1) == t.charAt(j - 1)) {
    //         return dp[i][j] = helper(i - 1, j - 1, s, t, dp) + helper(i - 1, j, s, t, dp);
    //     }
    //     return dp[i][j] = helper(i - 1, j, s, t, dp);
    // }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s, t));
        // 5
    }
}
