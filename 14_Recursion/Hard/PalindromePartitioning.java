// Palindrome Partitioning - https://leetcode.com/problems/palindrome-partitioning/description/

// Given a string s, partition s such that every substring of the partition is a palindrome. 
// Return all possible palindrome partitioning of s.

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        getPartitions(0, s.length(), s, new ArrayList<>(), ans);
        return ans;
    }

    private static void getPartitions(int idx, int n, String s, List<String> list, List<List<String>> ans) {
        if (idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                getPartitions(i + 1, n, s, list, ans);
                list.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
        // [[a, a, b], [aa, b]]
    }
}
