// Edit Distance - https://leetcode.com/problems/edit-distance/description/

// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word :
// Insert a character
// Delete a character
// Replace a character

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

import java.util.Arrays;

public class EditDistance {
    // -- Tabulation with Space Optimization --
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++)
            dp[j] = j;
        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            temp[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[j] = dp[j - 1];
                } else {
                    int insert = 1 + temp[j - 1];
                    int delete = 1 + dp[j];
                    int replace = 1 + dp[j - 1];
                    temp[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            dp = temp;
        }
        return dp[n];
    }

    // -- Memoization --
    // public static int minDistance(String word1, String word2) {
    //     int m = word1.length();
    //     int n = word2.length();
    //     int[][] dp = new int[m + 1][n + 1];
    //     for (int i = 0; i <= m; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(m, n, word1, word2, dp);
    // }

    // private static int helper(int i, int j, String word1, String word2, int[][] dp) {
    //     if (i == 0)
    //         return j;
    //     if (j == 0)
    //         return i;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    //         return dp[i][j] = helper(i - 1, j - 1, word1, word2, dp);
    //     }
    //     int insert = 1 + helper(i, j - 1, word1, word2, dp);
    //     int delete = 1 + helper(i - 1, j, word1, word2, dp);
    //     int replace = 1 + helper(i - 1, j - 1, word1, word2, dp);
    //     return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    // }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
        // 3
    }
}
