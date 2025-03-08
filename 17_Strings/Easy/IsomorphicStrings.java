// Isomorphic Strings - https://leetcode.com/problems/isomorphic-strings/description/

// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Input: s = "egg", t = "add"
// Output: true

// Explanation:
// The strings s and t can be made identical by:
// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.

import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (mapST.containsKey(charS) && mapST.get(charS) != charT) {
                return false;
            }
            if (mapTS.containsKey(charT) && mapTS.get(charT) != charS) {
                return false;
            }
            mapST.put(charS, charT);
            mapTS.put(charT, charS);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
        // true
    }
}
