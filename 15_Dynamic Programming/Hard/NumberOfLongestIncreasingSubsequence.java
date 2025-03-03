// Number of Longest Increasing Subsequence - https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

// Given an integer array nums, return the number of longest increasing subsequences.

// Notice that the sequence has to be strictly increasing.

// Input: nums = [1,3,5,4,7]
// Output: 2
// Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int longest = 1;
        for (int idx = 0; idx < n; idx++) {
            dp[idx] = 1;
            count[idx] = 1;
            for (int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if (nums[idx] > nums[prevIdx]) {
                    if (dp[idx] < 1 + dp[prevIdx]) {
                        dp[idx] = 1 + dp[prevIdx];
                        count[idx] = count[prevIdx];
                    } else if (dp[idx] == 1 + dp[prevIdx]) {
                        count[idx] += count[prevIdx];
                    }
                }
            }
            longest = Math.max(longest, dp[idx]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == longest)
                ans += count[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findNumberOfLIS(nums));
        // 2
    }
}
