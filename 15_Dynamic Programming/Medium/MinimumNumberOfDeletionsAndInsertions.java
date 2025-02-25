// Minimum Number of Deletions and Insertions - https://www.naukri.com/code360/problems/minimum-number-of-deletions-and-insertions_4244510?

// You are given 2 non-empty strings 's1' and 's2' consisting of lowercase English alphabets only.

// In one operation you can do either of the following on 's1':
// (1) Remove a character from any position in 's1'.
// (2) Add a character to any position in 's1'.

// Find the minimum number of operations required to convert string 's1' into 's2'.

// Input: 's1' = "abcd", 's2' = "anc"
// Output: 3
// Explanation:
// Here, 's1' = "abcd", 's2' = "anc".
// In one operation remove 's1[3]', after this operation 's1' becomes "abc".    
// In the second operation remove 's1[1]', after this operation 's1' becomes "ac".
// In the third operation add 'n' in 's1[1]', after this operation 's1' becomes "anc".

// Hence, the minimum operations required will be 3. It can be shown that there's no way to convert s1 into s2 in less than 3 moves.

public class MinimumNumberOfDeletionsAndInsertions {
    public static int canYouMake(String s1, String s2) {
        int totalOperations = s1.length() + s2.length();
        return totalOperations - (2 * longestCommonSubsequence(s1, s2));
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    temp[j] = 1 + dp[j - 1];
                else
                    temp[j] = Math.max(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
        System.out.println(canYouMake(s1, s2));
        // 3
    }
}
