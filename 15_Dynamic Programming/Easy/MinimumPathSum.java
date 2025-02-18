// Minimum Path Sum - https://leetcode.com/problems/minimum-path-sum/description/

// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

import java.util.Arrays;

public class MinimumPathSum {
    // -- Tabulation with Space Optimization --
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                } else {
                    int up = grid[i][j] + (i > 0 ? dp[j] : (int) 1e9);
                    int left = grid[i][j] + (j > 0 ? temp[j - 1] : (int) 1e9);
                    temp[j] = Math.min(up, left);
                }
            }
            dp = temp;
        }
        return dp[n - 1];
    }

    // -- Memoization --
    // public static int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < m; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(m - 1, n - 1, grid, dp);
    // }

    // private static int helper(int i, int j, int[][] grid, int[][] dp) {
    //     if (i == 0 && j == 0)
    //         return grid[i][j];
    //     if (i < 0 || j < 0)
    //         return (int) 1e9;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int up = grid[i][j] + helper(i - 1, j, grid, dp);
    //     int left = grid[i][j] + helper(i, j - 1, grid, dp);
    //     return dp[i][j] = Math.min(up, left);
    // }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(grid));
        // 7
    }
}
