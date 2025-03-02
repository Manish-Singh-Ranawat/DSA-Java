// Longest String Chain - https://leetcode.com/problems/longest-string-chain/description/

// You are given an array of words where each word consists of lowercase English letters.

// wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

// For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

// Return the length of the longest possible word chain with words chosen from the given list of words.

// Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
// Output: 5
// Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].

import java.util.Arrays;

public class LongestStringChain {
    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        int ans = 1;
        for (int idx = 0; idx < n; idx++) {
            dp[idx] = 1;
            for (int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if (isPossible(words[idx], words[prevIdx])) {
                    dp[idx] = Math.max(dp[idx], 1 + dp[prevIdx]);
                }
            }
            ans = Math.max(ans, dp[idx]);
        }
        return ans;
    }

    private static boolean isPossible(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n + 1)
            return false;
        int i = 0;
        int j = 0;
        while (i < m) {
            if (j < n && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return i == m && j == n;
    }

    public static void main(String[] args) {
        String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
        System.out.println(longestStrChain(words));
        // 5
    }
}
