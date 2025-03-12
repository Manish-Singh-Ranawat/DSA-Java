// Count Palindromic Subsequences - https://www.naukri.com/code360/problems/count-palindromic-subsequences_1062696?leftPanelTabValue=SUBMISSION

// A subsequence of a string is achieved by removing some (possibly 0) characters without changing the order of the remaining characters.

// You have been given a string 's'.

// Find the number of non-empty palindromic subsequences (not necessarily be distinct) in string 's' and return that number modulo 10 ^ 9 + 7.

// Input: 's' = "pqqr"
// Output: 5
// Explanation: The subsequences are: p, q, q, r, qq
// Please note that both "q" are considered different.

import java.util.Arrays;

public class CountPalindromicSubsequences {
    // Tabulation
    public static int countPalindromicSubseq(String s) {
        int n = s.length();
        int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (1 + dp[i + 1][j] + dp[i][j - 1]) % MOD;
                } else {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]) % MOD;
                }
            }
        }
        return dp[0][n - 1];
    }

    // Memoization
    // public static int countPalindromicSubseq(String s) {
    //     int n = s.length();
    //     int MOD = (int) 1e9 + 7;
    //     int[][] dp = new int[n][n];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(0, n - 1, s, dp, MOD);
    // }

    // private static int helper(int i, int j, String s, int[][] dp, int MOD) {
    //     if (i > j)
    //         return 0;
    //     if (i == j)
    //         return 1;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     if (s.charAt(i) == s.charAt(j)) {
    //         return dp[i][j] = (1 + helper(i + 1, j, s, dp, MOD) + helper(i, j - 1, s, dp, MOD)) % MOD;
    //     } else {
    //         return dp[i][j] = (helper(i + 1, j, s, dp, MOD) + helper(i, j - 1, s, dp, MOD)
    //                 - helper(i + 1, j - 1, s, dp, MOD)) % MOD;
    //     }
    // }

    public static void main(String[] args) {
        String s = "pqqr";
        System.out.println(countPalindromicSubseq(s));
        // 5
    }
}
