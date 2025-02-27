// Best Time to Buy and Sell Stock II - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Total profit is 4 + 3 = 7.

import java.util.Arrays;

public class BestTimeToBuyAndSellStock_II {
    // -- Greedy --
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    
    // -- Tabulation with Space Optimization --
    // public static int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[] dp = new int[2];
    //     for (int idx = n - 1; idx >= 0; idx--) {
    //         int[] temp = new int[2];
    //         temp[1] = Math.max(-prices[idx] + dp[0], dp[1]);
    //         temp[0] = Math.max(prices[idx] + dp[1], dp[0]);
    //         dp = temp;
    //     }
    //     return dp[1];
    // }

    // -- Memoization --
    // public static int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp = new int[n][2];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(0, 1, prices, dp);
    // }

    // private static int helper(int idx, int buy, int[] prices, int[][] dp) {
    //     if (idx == prices.length) {
    //         return 0;
    //     }
    //     if (dp[idx][buy] != -1)
    //         return dp[idx][buy];
    //     int profit = 0;
    //     if (buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx + 1, 0, prices, dp), helper(idx + 1, 1, prices, dp));
    //     } else {
    //         profit = Math.max(prices[idx] + helper(idx + 1, 1, prices, dp), helper(idx + 1, 0, prices, dp));
    //     }
    //     return dp[idx][buy] = profit;
    // }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
        // 7
    }
}
