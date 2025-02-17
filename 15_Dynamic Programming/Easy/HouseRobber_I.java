// House Robber - https://leetcode.com/problems/house-robber/description/

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobber_I {
    // -- Tabulation with Space Optimization --
    public static int rob(int[] nums) {
        int n = nums.length;
        int prev2 = 0;
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            int pick = prev2 + nums[i];
            int notPick = prev;
            int cur = Math.max(pick, notPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    // -- Memoization --
    // public static int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return helper(n - 1, nums, dp);
    // }

    // private static int helper(int i, int[] nums, int[] dp) {
    //     if (i == 0)
    //         return nums[i];
    //     if (i < 0)
    //         return 0;
    //     if (dp[i] != -1)
    //         return dp[i];
    //     int pick = helper(i - 2, nums, dp) + nums[i];
    //     int notPick = helper(i - 1, nums, dp);
    //     return dp[i] = Math.max(pick, notPick);
    // }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));
        // 12
    }
}
