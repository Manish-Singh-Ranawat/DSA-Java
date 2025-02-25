// Minimum Insertion Steps to Make a String Palindrome - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

// Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.

// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".

public class MinimumInsertionStepsToMakeStringPalindrome {
    public static int minInsertions(String s) {
        int n = s.length();
        return n - longestPalindromeSubseq(s);
    }

    private static int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int n = r.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1))
                    temp[j] = 1 + dp[j - 1];
                else
                    temp[j] = Math.max(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "mbadm";
        System.out.println(minInsertions(s));
        // 2
    }
}
