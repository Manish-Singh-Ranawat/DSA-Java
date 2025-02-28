// Best Time to Buy and Sell Stock with Cooldown - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions :
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

// Note : You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    // -- Tabulation with Space Optimization --
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp2 = new int[2];
        int[] dp1 = new int[2];
        for (int idx = n - 1; idx >= 0; idx--) {
            int[] temp = new int[2];
            temp[1] = Math.max(-prices[idx] + dp1[0], dp1[1]);
            temp[0] = Math.max(prices[idx] + dp2[1], dp1[0]);
            dp2 = dp1;
            dp1 = temp;
        }
        return dp1[1];
    }

    // -- Memoization --
    // public static int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp = new int[n][2];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(0, 1, prices, dp);
    // }

    // private static int helper(int idx, int buy, int[] prices, int[][] dp) {
    //     if (idx >= prices.length) {
    //         return 0;
    //     }
    //     if (dp[idx][buy] != -1)
    //         return dp[idx][buy];
    //     int profit = 0;
    //     if (buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx + 1, 0, prices, dp), helper(idx + 1, 1, prices, dp));
    //     } else {
    //         profit = Math.max(prices[idx] + helper(idx + 2, 1, prices, dp), helper(idx + 1, 0, prices, dp));
    //     }
    //     return dp[idx][buy] = profit;
    // }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(prices));
        // 3
    }
}
