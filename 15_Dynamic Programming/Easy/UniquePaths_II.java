// Unique Paths II - https://leetcode.com/problems/unique-paths-ii/description/

// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The testcases are generated so that the answer will be less than or equal to 2 * 109.

// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right

import java.util.Arrays;

public class UniquePaths_II {
    // -- Tabulation with Space Optimization --
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {k
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                } else if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    int up = (i > 0) ? dp[j] : 0;
                    int left = (j > 0) ? temp[j - 1] : 0;
                    temp[j] = up + left;
                }
            }
            dp = temp;
        }
        return dp[n - 1];
    }

    // --Memoization--
    // public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }
    //     return helper(m - 1, n - 1, obstacleGrid, dp);
    // }

    // private static int helper(int i, int j, int[][] obstacleGrid, int[][] dp) {
    //     if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1)
    //         return 0;
    //     if (i == 0 && j == 0)
    //         return 1;
    //     if (i < 0 || j < 0)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int up = helper(i - 1, j, obstacleGrid, dp);
    //     int left = helper(i, j - 1, obstacleGrid, dp);
    //     return dp[i][j] = up + left;
    // }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.err.println(uniquePathsWithObstacles(obstacleGrid));
        // 2
    }
}
