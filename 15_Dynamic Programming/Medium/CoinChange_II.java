// Coin Change II - https://leetcode.com/problems/coin-change-ii/description/

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1

import java.util.Arrays;

public class CoinChange_II {
    // -- Tabulation with Space Optimization --
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int t = 0; t <= amount; t++)
            dp[t] = t % coins[0] == 0 ? 1 : 0;
        for (int idx = 1; idx < n; idx++) {
            int[] temp = new int[amount + 1];
            for (int t = 0; t <= amount; t++) {
                int notPick = dp[t];
                int pick = t >= coins[idx] ? temp[t - coins[idx]] : 0;
                temp[t] = notPick + pick;
            }
            dp = temp;
        }
        return dp[amount];  
    }
    // -- Memoization --
    // public static int change(int amount, int[] coins) {
    //     int n = coins.length;
    //     int[][] dp = new int[n][amount + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(n - 1, amount, coins, dp);
    // }

    // private static int helper(int idx, int amount, int[] coins, int[][] dp) {
    //     if (idx == 0)
    //         return amount % coins[0] == 0 ? 1 : 0;
    //     if (dp[idx][amount] != -1)
    //         return dp[idx][amount];
    //     int notPick = helper(idx - 1, amount, coins, dp);
    //     int pick = amount >= coins[idx] ? helper(idx, amount - coins[idx], coins, dp) : 0;
    //     return dp[idx][amount] = notPick + pick;
    // }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = { 1, 2, 5 };
        System.out.println(change(amount, coins));
        // 4
    }
}
