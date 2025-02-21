// 0 1 Knapsack - https://www.naukri.com/code360/problems/0-1-knapsack_920542?

// A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight that a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.

// Input : weight = [1, 2, 4, 5], value = [5, 4, 8, 6], n = 4, maxWeight = 5
// Output : 13

import java.util.Arrays;

public class ZeroOneKnapsack {
    // -- Tabulation with Space Optimization --
    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] dp = new int[maxWeight + 1];
        for (int w = weight[0]; w <= maxWeight; w++)
            dp[w] = value[0];
        for (int idx = 1; idx < n; idx++) {
            for (int w = maxWeight; w >= 0; w--) {
                int notPick = dp[w];
                int pick = w >= weight[idx] ? value[idx] + dp[w - weight[idx]] : Integer.MIN_VALUE;
                dp[w] = Math.max(notPick, pick);
            }
        }
        return dp[maxWeight];
    }

    // -- Memoization --
    // public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    //     int[][] dp = new int[n][maxWeight + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(n - 1, maxWeight, weight, value, dp);
    // }

    // private static int helper(int idx, int w, int[] weight, int[] value, int[][] dp) {
    //     if (idx == 0) {
    //         return w >= weight[0] ? value[0] : 0; 
    //     }
    //     if (dp[idx][w] != -1)
    //         return dp[idx][w];
    //     int notPick = helper(idx - 1, w, weight, value, dp);
    //     int pick = w >= weight[idx] ? value[idx] + helper(idx - 1, w - weight[idx], weight, value, dp)
    //             : Integer.MIN_VALUE;
    //     return dp[idx][w] = Math.max(notPick, pick);
    // }

    public static void main(String[] args) {
        int[] weight = { 1, 2, 4, 5 };
        int[] value = { 5, 4, 8, 6 };
        int n = 4;
        int maxWeight = 5;
        System.out.println(knapsack(weight, value, n, maxWeight));
        // 13
    }
}
