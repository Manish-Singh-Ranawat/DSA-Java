// Matrix Chain Multiplication - https://www.naukri.com/code360/problems/matrix-chain-multiplication_975344?

// Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices. The cost of matrix multiplication is defined as the number of scalar multiplications. A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.

// Input : arr = [4, 5, 3, 2], n = 4
// Output : 70
// Explanation : There are three matrices of dimensions A = [4 5], B = [5 3] and C = [3 2]. The most efficient order of multiplication is A * ( B * C).
// Cost of ( B * C ) = 5 * 3 * 2 = 30  and (B * C) = [5 2] and A * (B * C) = [ 4 5] * [5 2] = 4 * 5 * 2 = 40. So the overall cost is equal to 30 + 40 =70.

import java.util.Arrays;

public class MatrixChainMultiplication {
    // -- Tabulation with Space Optimization --
    public static int matrixMultiplication(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 0;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }

    // -- Memoization --
    // public static int matrixMultiplication(int[] arr, int n) {
    //     int[][] dp = new int[n][n];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(1, n - 1, arr, dp);
    // }

    // private static int helper(int i, int j, int[] arr, int[][] dp) {
    //     if (i == j)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int min = Integer.MAX_VALUE;
    //     for (int k = i; k < j; k++) {
    //         int steps = (arr[i - 1] * arr[k] * arr[j]) + helper(i, k, arr, dp) + helper(k
    //                 + 1, j, arr, dp);
    //         min = Math.min(min, steps);
    //     }
    //     return dp[i][j] = min;
    // }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 3, 2 };
        int n = arr.length;
        System.out.println(matrixMultiplication(arr, n));
        // 70
    }
}
