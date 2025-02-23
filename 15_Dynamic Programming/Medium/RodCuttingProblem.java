// Rod cutting problem - https://www.naukri.com/code360/problems/rod-cutting-problem_800284?

// Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.

// Note:
// 1. The sizes will range from 1 to ‘N’ and will be integers.
// 2. The sum of the pieces cut should be equal to ‘N’.
// 3. Consider 1-based indexing.

// Input : n = 5, price = [2, 5, 7, 8, 10]
// Output : 12
// Explanation :
// All possible partitions are:
// 1,1,1,1,1           max_cost=(2+2+2+2+2) = 10
// 1,1,1,2             max_cost=(2+2+2+5) = 11
// 1,1,3               max_cost=(2+2+7) = 11
// 1,4                 max_cost=(2+8) = 10
// 5                   max_cost=(10) = 10
// 2,3                 max_cost=(5+7) = 12
// 1,2,2               max _cost=(1+5+5) = 12    
// Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.

import java.util.Arrays;

public class RodCuttingProblem {
    // -- Tabulation with Space Optimization --
    public static int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = i * price[0];
        for (int idx = 1; idx < n; idx++) {
            for (int length = 0; length <= n; length++) {
                int notPick = dp[length];
                int rodLength = idx + 1;
                int pick = length >= rodLength ? price[idx] + dp[length - rodLength] : Integer.MIN_VALUE;
                dp[length] = Math.max(notPick, pick);
            }
        }
        return dp[n];
    }

    // -- Memoization --
    // public static int cutRod(int price[], int n) {
    //     int[][] dp = new int[n][n + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(n - 1, n, price, dp);
    // }

    // private static int helper(int idx, int n, int[] price, int[][] dp) {
    //     if (idx == 0)
    //         return n * price[0];
    //     if (dp[idx][n] != -1)
    //         return dp[idx][n];
    //     int notPick = helper(idx - 1, n, price, dp);
    //     int rodLength = idx + 1;
    //     int pick = n >= rodLength ? price[idx] + helper(idx, n - rodLength, price, dp) : Integer.MIN_VALUE;
    //     return dp[idx][n] = Math.max(notPick, pick);
    // }

    public static void main(String[] args) {
        int[] price = { 2, 5, 7, 8, 10 };
        int n = 5;
        System.out.println(cutRod(price, n));
        // 12
    }
}
