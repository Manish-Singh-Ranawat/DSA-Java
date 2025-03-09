// Valid Anagram - https://leetcode.com/problems/valid-anagram/description/

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Input: s = "anagram", t = "nagaram"
// Output: true

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            hash[ch - 'a']--;
            if (hash[ch - 'a'] < 0)
                return false;
        }
        for (int it : hash) {
            if (it != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        // true
    }
}
