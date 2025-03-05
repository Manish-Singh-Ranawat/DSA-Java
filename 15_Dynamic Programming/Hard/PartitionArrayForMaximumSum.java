// Partition Array for Maximum Sum - https://leetcode.com/problems/partition-array-for-maximum-sum/description/

// Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

// Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.

// Input: arr = [1,15,7,9,2,5,10], k = 3
// Output: 84
// Explanation: arr becomes [15,15,15,9,10,10,10]

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    // -- Tabulation --
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            int maxVal = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                maxVal = Math.max(maxVal, arr[j]);
                int sum = (maxVal * len) + dp[j + 1];
                dp[i] = Math.max(dp[i], sum);
            }
        }
        return dp[0];
    }

    // -- Memoization --
    // public static int maxSumAfterPartitioning(int[] arr, int k) {
    //     int n = arr.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return helper(0, k, n, arr, dp);
    // }

    // private static int helper(int i, int k, int n, int[] arr, int[] dp) {
    //     if (i == n)
    //         return 0;
    //     if (dp[i] != -1)
    //         return dp[i];
    //     int ans = Integer.MIN_VALUE;
    //     int len = 0;
    //     int maxVal = Integer.MIN_VALUE;
    //     for (int j = i; j < Math.min(n, i + k); j++) {
    //         len++;
    //         maxVal = Math.max(maxVal, arr[j]);
    //         int sum = (maxVal * len) + helper(j + 1, k, n, arr, dp);
    //         ans = Math.max(ans, sum);
    //     }
    //     return dp[i] = ans;
    // }

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
        // 84
    }
}
