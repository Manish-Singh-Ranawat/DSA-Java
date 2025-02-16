// Climbing Stairs - https://leetcode.com/problems/climbing-stairs/description/

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

public class ClimbingStairs {
    // -- Tabulation with Space Optimization --
    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        int prev2 = 1;
        int prev = 2;
        for (int i = 3; i <= n; i++) {
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    // -- Memoization --
    // public static int climbStairs(int n) {
    //     int[] dp = new int[n + 1];
    //     return helper(n, dp);
    // }

    // private static int helper(int i, int[] dp) {
    //     if (i == 1 || i == 2)
    //         return i;
    //     if (dp[i] != 0)
    //         return dp[i];
    //     int left = helper(i - 1, dp);
    //     int right = 0;
    //     if (i > 1) {
    //         right = helper(i - 2, dp);
    //     }
    //     return dp[i] = left + right;
    // }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
        // 3
    }
}
