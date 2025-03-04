// Burst Balloons - https://leetcode.com/problems/burst-balloons/description/

// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

// Return the maximum coins you can collect by bursting the balloons wisely.

// Input: nums = [3,1,5,8]
// Output: 167
// Explanation:
// nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
// coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

import java.util.Arrays;

public class BurstBalloons {
    // -- Tabulation --
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++)
            arr[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int coins = arr[k] * arr[j + 1] * arr[i - 1] + dp[i][k - 1]
                            + dp[k + 1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }

    // -- Memoization --
    // public static int maxCoins(int[] nums) {
    //     int n = nums.length;
    //     int[] arr = new int[n + 2];
    //     arr[0] = 1;
    //     arr[n + 1] = 1;
    //     for (int i = 0; i < n; i++)
    //         arr[i + 1] = nums[i];
    //     int[][] dp = new int[n + 2][n + 2];
    //     for (int i = 0; i < n + 2; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(1, n, arr, dp);
    // }

    // private static int helper(int i, int j, int[] arr, int[][] dp) {
    //     if (i > j)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int max = Integer.MIN_VALUE;
    //     for (int k = i; k <= j; k++) {
    //         int coins = arr[k] * arr[j + 1] * arr[i - 1] + helper(i, k - 1, arr, dp) + helper(k + 1, j, arr, dp);
    //         max = Math.max(max, coins);
    //     }
    //     return dp[i][j] = max;
    // }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(maxCoins(nums));
        // 167
    }
}
