// Best Time to Buy and Sell Stock with Transaction Fee - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

// Note :
// You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// The transaction fee is only charged once for each stock purchase and sale.

// Input: prices = [1,3,2,8,4,9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// - Buying at prices[0] = 1
// - Selling at prices[3] = 8
// - Buying at prices[4] = 4
// - Selling at prices[5] = 9
// The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    // -- Tabulation with Space Optimization --
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];
        for (int idx = n - 1; idx >= 0; idx--) {
            int[] temp = new int[2];
            temp[1] = Math.max(-prices[idx] + dp[0], dp[1]);
            temp[0] = Math.max(prices[idx] - fee + dp[1], dp[0]);
            dp = temp;
        }
        return dp[1];
    }

    // -- Memoization --
    // public static int maxProfit(int[] prices, int fee) {
    //     int n = prices.length;
    //     int[][] dp = new int[n][2];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(0, 1, prices, fee, dp);
    // }

    // private static int helper(int idx, int buy, int[] prices, int fee, int[][] dp) {
    //     if (idx == prices.length) {
    //         return 0;
    //     }
    //     if (dp[idx][buy] != -1)
    //         return dp[idx][buy];
    //     int profit = 0;
    //     if (buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx + 1, 0, prices, fee, dp), helper(idx + 1, 1, prices, fee, dp));
    //     } else {
    //         profit = Math.max(prices[idx] - fee + helper(idx + 1, 1, prices, fee, dp),
    //                 helper(idx + 1, 0, prices, fee, dp));
    //     }
    //     return dp[idx][buy] = profit;
    // }

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
        // 8
    }
}
