// Word Break - https://leetcode.com/problems/word-break/description/

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        return getPartitions(0, s.length(), s, set);
    }

    private static boolean getPartitions(int idx, int n, String s, HashSet<String> set) {
        if (idx == n) {
            return true;
        }
        for (int i = idx; i < n; i++) {
            String part = s.substring(idx, i + 1);
            if (set.contains(part)) {
                if (getPartitions(i + 1, n, s, set)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(List.of("leet", "code"));
        System.out.println(wordBreak(s, wordDict));
        // true
    }
}
