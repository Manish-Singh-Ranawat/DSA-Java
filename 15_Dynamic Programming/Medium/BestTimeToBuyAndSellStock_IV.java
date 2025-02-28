// Best Time to Buy and Sell Stock IV - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Input: k = 2, prices = [3,2,6,5,0,3]
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

public class BestTimeToBuyAndSellStock_IV {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k + 1][2];
        for (int idx = n - 1; idx >= 0; idx--) {
            int[][] temp = new int[k + 1][2];
            for (int count = 1; count <= k; count++) {
                temp[count][1] = Math.max(-prices[idx] + dp[count][0],
                        dp[count][1]);
                temp[count][0] = Math.max(prices[idx] + dp[count - 1][1],
                        dp[count][0]);
            }
            dp = temp;
        }
        return dp[k][1];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        int k = 2;
        System.out.println(maxProfit(k, prices));
        // 7
    }
}
