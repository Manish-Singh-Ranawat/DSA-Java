// Unbounded Knapsack - https://www.naukri.com/code360/problems/unbounded-knapsack_1215029?

// You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.

// You need to fill the knapsack with the items in such a way that you get the maximum profit. You are allowed to take one item multiple times.

// Input: n = 3, w = 10, profit = [5, 11, 13], weight = [2, 4, 6]
// Output: 27

// Explanation: We can fill the knapsack as:
// 1 item of weight 6 and 1 item of weight 4.
// 1 item of weight 6 and 2 items of weight 2.
// 2 items of weight 4 and 1 item of weight 2.
// 5 items of weight 2.

// The maximum profit will be from case 3 = 11 + 11 + 5 = 27. Therefore maximum profit = 27.

import java.util.Arrays;

public class UnboundedKnapsack {
    // -- Tabulation with Space Optimization --
    public static int unboundedKnapsack(int n, int W, int[] profit, int[] weight) {
        int[] dp = new int[W + 1];
        for (int wt = 0; wt <= W; wt++) {
            dp[wt] = (wt / weight[0]) * profit[0];
        }
        for (int idx = 1; idx < n; idx++) {
            for (int wt = 0; wt <= W; wt++) {
                int notPick = dp[wt];
                int pick = wt >= weight[idx] ? profit[idx] + dp[wt - weight[idx]] : 0;
                dp[wt] = Math.max(notPick, pick);
            }
        }
        return dp[W];
    }

    // -- Memoization --
    // public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
    //     int[][] dp = new int[n][w + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(n - 1, w, profit, weight, dp);
    // }

    // private static int helper(int idx, int w, int[] profit, int[] weight, int[][] dp) {
    //     if (idx == 0) {
    //         return (w / weight[0]) * profit[0];
    //     }
    //     if (dp[idx][w] != -1)
    //         return dp[idx][w];
    //     int notPick = helper(idx - 1, w, profit, weight, dp);
    //     int pick = w >= weight[idx] ? profit[idx] + helper(idx, w - weight[idx],
    //             profit, weight, dp) : 0;
    //     return dp[idx][w] = Math.max(notPick, pick);
    // }

    public static void main(String[] args) {
        int n = 3;
        int w = 10;
        int[] profit = { 5, 11, 13 };
        int[] weight = { 2, 4, 6 };
        System.out.println(unboundedKnapsack(n, w, profit, weight));
        // 27
    }
}
