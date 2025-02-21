// Count Subsets with Sum K - https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532

// You are given an array 'nums' of size 'n' containing positive integers and a target sum 'k'.

// Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.

// Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

// Input: nums = [1, 1, 4, 5], k = 5
// Output: 3
// Explanation: The possible ways are: [[1, 4], [1, 4], [5]]
// Hence the output will be 3. Please note that both 1 present in 'nums' are treated differently.

import java.util.Arrays;

public class CountSubsetsWithSumK {
    // -- Tabulation with Space Optimization --
    public static int findWays(int[] nums, int k) {
        int MOD = 1000000007;
        int n = nums.length;
        int[] dp = new int[k + 1];
        if (nums[0] == 0)
            dp[0] = 2;
        else
            dp[0] = 1;
        if (nums[0] != 0 && nums[0] <= k)
            dp[nums[0]] = 1;
        for (int idx = 1; idx < n; idx++) {
            int[] temp = new int[k + 1];
            for (int target = 0; target <= k; target++) {
                int notPick = dp[target];
                int pick = target >= nums[idx] ? dp[target - nums[idx]] : 0;
                temp[target] = (notPick + pick) % MOD;
            }
            dp = temp;
        }
        return dp[k];
    }

    // -- Memoization --
    // public static int findWays(int[] nums, int k) {
    //     int MOD = 1000000007;
    //     int n = nums.length;
    //     int[][] dp = new int[n][k + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(n - 1, k, nums, dp, MOD);
    // }

    // public static int helper(int idx, int k, int[] nums, int[][] dp, int MOD) {
    //     if (idx == 0) {
    //         if (k == 0 && nums[0] == 0)
    //             return 2;
    //         return k == 0 || k == nums[0] ? 1 : 0;
    //     }
    //     if (dp[idx][k] != -1)
    //         return dp[idx][k];
    //     int notPick = helper(idx - 1, k, nums, dp, MOD);
    //     int pick = k >= nums[idx] ? helper(idx - 1, k - nums[idx], nums, dp, MOD) : 0;
    //     return dp[idx][k] = (notPick + pick) % MOD;
    // }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 4, 5 };
        int k = 5;
        System.out.println(findWays(nums, k));
        // 3
    }
}