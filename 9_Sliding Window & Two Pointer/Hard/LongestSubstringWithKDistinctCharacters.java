// Longest Substring with At Most K Distinct Characters - https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM

// You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

// The string str will contain only lowercase alphabets.    

// Input : k = 2, str = "abbbbbbc"
// Output : 7
// Explanation : For the first test case, ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.

import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacters {
    public static int kDistinctChars(int k, String str) {
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (r < n) {
            char rChar = str.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            if (map.size() > k) {
                char lChar = str.charAt(l);
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
        String str = "abbbbbbc";
        int k = 2;
        System.out.println(kDistinctChars(k, str));
        // 7
    }
}
