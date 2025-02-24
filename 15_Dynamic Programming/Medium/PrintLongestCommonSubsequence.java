// Print Longest Common Subsequence - https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383?leftPanelTabValue=PROBLEM

// You are given two strings ‘s1’ and ‘s2’.

// Return the longest common subsequence of these strings.
// If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.

// Note : Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ that is also a subsequence of ‘s2’. A ‘subsequence’ of ‘s1’ is a string that can be formed by deleting one or more (possibly zero) characters from ‘s1’.

// Input: s1  = “abcab”, s2 = “cbab”
// Output: “cab”
// Explanation: “cab” is one valid longest subsequence present in both strings ‘s1’ , ‘s2’.

public class PrintLongestCommonSubsequence {
    public static String findLCS(int m, int n, String s1, String s2) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int len = dp[m][n];
        char[] ans = new char[len];
        int i = m;
        int j = n;
        int idx = len - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans[idx] = s1.charAt(i - 1);
                i--;
                j--;
                idx--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        String s1 = "abcab";
        String s2 = "cbab";
        System.out.println(findLCS(s1.length(), s2.length(), s1, s2));
        // cab
    }
}
