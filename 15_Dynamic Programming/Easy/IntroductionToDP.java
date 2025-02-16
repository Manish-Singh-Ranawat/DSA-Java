// Introduction to DP - https://www.geeksforgeeks.org/problems/introduction-to-dp/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-dp

// Geek is learning data structures, and he recently learned about the top-down and bottom-up dynamic programming approaches. Geek is having trouble telling them apart from one another.

// When given an integer n, where n is based on a 0-based index, find the nth Fibonacci number.

// Every ith number in the series equals the sum of the (i-1)th and (i-2)th numbers, where the first and second numbers are specified as 0 and 1, respectively.

// For the given issue, code both top-down and bottom-up approaches.

// Note : As the answer might be large, return the final answer modulo 109 + 7

// Input: n = 5
// Output: 5
// Explanation: 0,1,1,2,3,5 as we can see 5th number is 5.

public class IntroductionToDP {
    static int mod = (int) 1e9 + 7;

    static long topDown(int n) {
        long[] dp = new long[n + 1];
        return topDownHelper(n, dp);
    }

    static long bottomUp(int n) {
        long prev2 = 0;
        long prev = 1;
        for (int i = 2; i <= n; i++) {
            long cur = (prev + prev2) % mod;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    private static long topDownHelper(int n, long[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        return dp[n] = (topDownHelper(n - 1, dp) + topDownHelper(n - 2, dp)) % mod;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(topDown(n)); // 5
        System.out.println(bottomUp(n)); // 5
    }
}
