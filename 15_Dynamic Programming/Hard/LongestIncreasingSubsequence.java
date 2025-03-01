// Longest Increasing Subsequence - https://leetcode.com/problems/longest-increasing-subsequence/description/

// Given an integer array nums, return the length of the longest strictly increasing subsequence.

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 1;
        for (int idx = 0; idx < n; idx++) {
            dp[idx] = 1;
            for (int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if (nums[idx] > nums[prevIdx]) {
                    dp[idx] = Math.max(dp[idx], 1 + dp[prevIdx]);
                }
            }
            ans = Math.max(ans, dp[idx]);
        }
        return ans;
    }

    // -- Tabulation with Space Optimization --
    // public static int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n + 1];
    //     for (int idx = n - 1; idx >= 0; idx--) {
    //         int[] temp = new int[n + 1];
    //         for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
    //             int notPick = dp[prevIdx + 1];
    //             int pick = prevIdx == -1 || nums[idx] > nums[prevIdx] ? 1 + dp[idx + 1] : 0;
    //             temp[prevIdx + 1] = Math.max(pick, notPick);
    //         }
    //         dp = temp;
    //     }
    //     return dp[0];
    // }

    // -- Memoization --
    // public static int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[][] dp = new int[n][n + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(0, -1, nums, dp);
    // }

    // private static int helper(int idx, int prevIdx, int[] nums, int[][] dp) {
    //     if (idx == nums.length)
    //         return 0;
    //     if (dp[idx][prevIdx + 1] != -1)
    //         return dp[idx][prevIdx + 1];
    //     int notPick = helper(idx + 1, prevIdx, nums, dp);
    //     int pick = prevIdx == -1 || nums[idx] > nums[prevIdx] ? 1 + helper(idx + 1,
    //             idx, nums, dp) : 0;
    //     return dp[idx][prevIdx + 1] = Math.max(pick, notPick);
    // }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
        // 4
    }
}
