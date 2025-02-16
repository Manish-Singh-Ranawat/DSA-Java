// Minimal Cost - https://www.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost

// Given an array arr[] of size n, where arr[i] denotes the height of ith stone. Geek starts from stone 0 and from stone i, he can jump to stones i + 1, i + 2, … i + k. The cost for jumping from stone i to stone j is abs(arr[i] – arr[j]). Find the minimum cost for Geek to reach the last stone.

// Input: k = 3, arr[]= [10, 30, 40, 50, 20]
// Output: 30
// Explanation: Geek will follow the path 1->2->5, the total cost would be |10-30| + |30-20| = 30, which is minimum.

import java.util.Arrays;

public class FrogJumpWithKDistances {
    // -- Tabulation --
    public static int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }

    // -- Memoization --
    // public static int minimizeCost(int k, int arr[]) {
    //     int n = arr.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return helper(n - 1, k, arr, dp);
    // }

    // private static int helper(int i, int k, int[] arr, int[] dp) {
    //     if (i == 0)
    //         return 0;
    //     if (dp[i] != -1)
    //         return dp[i];
    //     int minSteps = Integer.MAX_VALUE;
    //     for (int j = 1; j <= k; j++) {
    //         if (i - j >= 0) {
    //             int jump = helper(i - j, k, arr, dp) + Math.abs(arr[i] - arr[i - j]);
    //             minSteps = Math.min(minSteps, jump);
    //         }
    //     }
    //     return dp[i] = minSteps;
    // }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = { 10, 30, 40, 50, 20 };
        System.out.println(minimizeCost(k, arr));
        // 30
    }
}
