// Shortest Palindrome - https://leetcode.com/problems/shortest-palindrome/description/

// You are given a string s. You can convert s to a palindrome by adding characters in front of it.

// Return the shortest palindrome you can find by performing this transformation.

// Input: s = "aacecaaa"
// Output: "aaacecaaa"

public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        long BASE = 29;
        long MOD = (long) 1e9 + 7;
        long prefixHash = 0;
        long suffixHash = 0;
        int n = s.length();
        long power = 1;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            prefixHash = (prefixHash * BASE + ch) % MOD;
            suffixHash = (suffixHash + ch * power) % MOD;
            power = (power * BASE) % MOD;
            if (prefixHash == suffixHash)
                idx = i;
        }
        StringBuilder reversedSuffix = new StringBuilder(s.substring(idx + 1)).reverse();
        return reversedSuffix.append(s).toString();
    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
        // aaacecaaa
    }
}
