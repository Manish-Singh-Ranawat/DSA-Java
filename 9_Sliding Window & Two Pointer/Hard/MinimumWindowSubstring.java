// Minimum Window Substring - https://leetcode.com/problems/minimum-window-substring/

// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char it : t.toCharArray()) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        int n = t.length();
        int m = s.length();
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int sIdx = -1;
        int count = 0;
        while (r < m) {
            char rChar = s.charAt(r);
            if (map.getOrDefault(rChar, 0) > 0) {
                count++;
            }
            map.put(rChar, map.getOrDefault(rChar, 0) - 1);
            while (count == n) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIdx = l;
                }
                char lChar = s.charAt(l);
                map.put(lChar, map.get(lChar) + 1);
                l++;
                if (map.get(lChar) > 0) {
                    count--;
                }
            }
            r++;
        }
        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        // BANC
    }
}
