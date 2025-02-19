// Minimum Falling Path Sum - https://leetcode.com/problems/minimum-falling-path-sum/description/

// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.

import java.util.Arrays;

public class MinimumFallingPathSum {
    // -- Tabulation with Space Optimization --
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++)
            dp[j] = matrix[0][j];
        for (int i = 1; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[j];
                int leftDiagonal = matrix[i][j] + (j > 0 ? dp[j - 1] : (int) 1e9);
                int rightDiagonal = matrix[i][j] + (j < n - 1 ? dp[j + 1] : (int) 1e9);
                temp[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            dp = temp;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[j]);
        }
        return min;
    }

    // -- Memoization --
    // public static int minFallingPathSum(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < m; i++)
    //         Arrays.fill(dp[i], -1);
    //     int min = Integer.MAX_VALUE;
    //     for (int j = 0; j < n; j++) {
    //         min = Math.min(min, helper(m - 1, j, matrix, dp));
    //     }
    //     return min;
    // }

    // private static int helper(int i, int j, int[][] matrix, int[][] dp) {
    //     if (j < 0 || j >= matrix[i].length)
    //         return (int) 1e9;
    //     if (i == 0)
    //         return matrix[i][j];
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int up = matrix[i][j] + helper(i - 1, j, matrix, dp);
    //     int leftDiagonal = matrix[i][j] + helper(i - 1, j - 1, matrix, dp);
    //     int rightDiagonal = matrix[i][j] + helper(i - 1, j + 1, matrix, dp);
    //     return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    // }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(matrix));
        // 13
    }
}
