// Unique Paths - https://leetcode.com/problems/unique-paths/

// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down

import java.util.Arrays;

public class UniquePaths_I {
    public static int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = m - 1;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }

    // -- Tabulation with Space Optimization --
    // public static int uniquePaths(int m, int n) {
    //     int[] dp = new int[n];
    //     for (int i = 0; i < m; i++) {
    //         int[] temp = new int[n];
    //         for (int j = 0; j < n; j++) {
    //             if (i == 0 && j == 0) {
    //                 temp[j] = 1;
    //             } else {
    //                 int up = (i > 0) ? dp[j] : 0;
    //                 int left = (j > 0) ? temp[j - 1] : 0;
    //                 temp[j] = up + left;
    //             }
    //         }
    //         dp = temp;
    //     }
    //     return dp[n - 1];
    // }

    //  -- Memoization --
    // public static int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }
    //     return helper(m - 1, n - 1, dp);
    // }

    // private static int helper(int i, int j, int[][] dp) {
    //     if (i == 0 && j == 0)
    //         return 1;
    //     if (i < 0 || j < 0)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int up = helper(i - 1, j, dp);
    //     int left = helper(i, j - 1, dp);
    //     return dp[i][j] = up + left;
    // }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths(m, n));
        // 3
    }
}
