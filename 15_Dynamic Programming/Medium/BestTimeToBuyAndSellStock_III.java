// Best Time to Buy and Sell Stock III - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete at most two transactions.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

import java.util.Arrays;

public class BestTimeToBuyAndSellStock_III {
    // -- Tabulation with Space Optimization --
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][2];
        for (int idx = n - 1; idx >= 0; idx--) {
            int[][] temp = new int[3][2];
            for (int count = 1; count <= 2; count++) {
                temp[count][1] = Math.max(-prices[idx] + dp[count][0],
                        dp[count][1]);
                temp[count][0] = Math.max(prices[idx] + dp[count - 1][1],
                        dp[count][0]);
            }
            dp = temp;
        }
        return dp[2][1];
    }

    // -- Memoization --
    // public static int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][][] dp = new int[n][3][2];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < 3; j++) {
    //             Arrays.fill(dp[i][j], -1);
    //         }
    //     }
    //     return helper(0, 2, 1, prices, dp);
    // }

    // private static int helper(int idx, int count, int buy, int[] prices, int[][][] dp) {
    //     if (count == 0 || idx == prices.length) {
    //         return 0;
    //     }
    //     if (dp[idx][count][buy] != -1)
    //         return dp[idx][count][buy];
    //     int profit = 0;
    //     if (buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx + 1, count, 0, prices, dp),
    //                 helper(idx + 1, count, 1, prices, dp));
    //     } else {
    //         profit = Math.max(prices[idx] + helper(idx + 1, count - 1, 1, prices, dp),
    //                 helper(idx + 1, count, 0, prices, dp));
    //     }
    //     return dp[idx][count][buy] = profit;
    // }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit(prices));
        // 6
    }
}
