// Palindrome Partitioning II - https://leetcode.com/problems/palindrome-partitioning-ii/description/

// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return the minimum cuts needed for a palindrome partitioning of s.

// Input: s = "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

import java.util.Arrays;

public class PalindromePartitioning_II {
    // -- Tabulation --
    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cut = 1 + dp[j + 1];
                    min = Math.min(min, cut);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }

    // -- Memoization --
    // public static int minCut(String s) {
    //     int n = s.length();
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return helper(0, n, s, dp) - 1;
    // }

    // private static int helper(int i, int n, String s, int[] dp) {
    //     if (i == n)
    //         return 0;
    //     if (dp[i] != -1)
    //         return dp[i];
    //     int min = Integer.MAX_VALUE;
    //     for (int j = i; j < n; j++) {
    //         if (isPalindrome(i, j, s)) {
    //             int cut = 1 + helper(j + 1, n, s, dp);
    //             min = Math.min(min, cut);
    //         }
    //     }
    //     return dp[i] = min;
    // }

    private static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
        // 1
    }
}
