// Longest Substring Without Repeating Characters - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// Given a string s, find the length of the longest substring without repeating characters.

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (r < n) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }
            map.put(ch, r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        // 3
    }
}
