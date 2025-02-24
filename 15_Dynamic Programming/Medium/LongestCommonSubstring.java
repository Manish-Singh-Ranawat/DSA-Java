// Longest Common Substring - https://www.naukri.com/code360/problems/longest-common-substring_1235207?

// You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.

// A substring is a continuous segment of a string. 

// Input: str1 = “abcjklp” , str2 = “acjkp”.
// Output: 3
// Explanation:  The longest common substring between ‘str1’ and ‘str2’ is “cjk”, of length 3.

public class LongestCommonSubstring {
    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    int val = 1 + dp[j - 1];
                    temp[j] = val;
                    ans = Math.max(ans, val);
                } else {
                    temp[j] = 0;
                }
            }
            dp = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "abcjklp";
        String str2 = "acjkp";
        System.out.println(lcs(str1, str2));
        // 3
    }
}
