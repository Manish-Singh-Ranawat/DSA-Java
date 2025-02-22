// Coin Change - https://leetcode.com/problems/coin-change/description/

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

import java.util.Arrays;

public class CoinChange_I {
    // -- Tabulation with Space Optimization --
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int t = 0; t <= amount; t++)
            dp[t] = t % coins[0] == 0 ? t / coins[0] : (int) 1e9;
        for (int idx = 1; idx < n; idx++) {
            int[] temp = new int[amount + 1];
            for (int t = 0; t <= amount; t++) {
                int notPick = dp[t];
                int pick = t >= coins[idx] ? 1 + temp[t - coins[idx]] : Integer.MAX_VALUE;
                temp[t] = Math.min(notPick, pick);
            }
            dp = temp;
        }
        int ans = dp[amount];
        return ans >= (int) 1e9 ? -1 : ans;
    }

    // -- Memoization --
    // public static int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     int ans = helper(n - 1, amount, coins, dp);
    //     return ans >= (int) 1e9 ? -1 : ans;
    // }

    // private static int helper(int idx, int amount, int[] coins, int[][] dp) {
    //     if (idx == 0)
    //         return amount % coins[0] == 0 ? amount / coins[0] : (int) 1e9;
    //     if (dp[idx][amount] != -1)
    //         return dp[idx][amount];
    //     int notPick = helper(idx - 1, amount, coins, dp);
    //     int pick = amount >= coins[idx] ? 1 + helper(idx, amount - coins[idx], coins, dp) : Integer.MAX_VALUE;
    //     return dp[idx][amount] = Math.min(notPick, pick);
    // }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        // 3
    }
}
