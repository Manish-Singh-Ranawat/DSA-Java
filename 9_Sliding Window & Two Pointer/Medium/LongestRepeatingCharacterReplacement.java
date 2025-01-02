// Longest Repeating Character Replacement - https://leetcode.com/problems/longest-repeating-character-replacement/description/

// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxFreq = 0;
        int maxLen = 0;
        while (r < n) {
            char rChar = s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(rChar));
            if ((r - l + 1) - maxFreq > k) {
                char lChar = s.charAt(l);
                if (map.get(lChar) == 1) {
                    map.remove(lChar);
                } else {
                    map.put(lChar, map.get(lChar) - 1);
                }
                l++;
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
        // 4
    }
}


