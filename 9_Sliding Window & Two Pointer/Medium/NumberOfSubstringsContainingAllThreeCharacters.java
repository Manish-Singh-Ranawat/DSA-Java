// Number of Substrings Containing All Three Characters - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

import java.util.HashMap;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
            int minIdx = Math.min(map.getOrDefault('a', -1), map.getOrDefault('b', -1));
            minIdx = Math.min(minIdx, map.getOrDefault('c', -1));
            count += minIdx + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
        // 10
    }
}
