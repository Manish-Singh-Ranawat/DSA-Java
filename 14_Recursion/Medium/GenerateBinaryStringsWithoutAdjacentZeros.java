// Generate Binary Strings Without Adjacent Zeros - https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/

// You are given a positive integer n.

// A binary string x is valid if all substrings of x of length 2 contain at least one "1".

// Return all valid strings with length n, in any order.

// Input: n = 3
// Output: ["010","011","101","110","111"]
// Explanation: The valid strings of length 3 are: "010", "011", "101", "110", and "111".

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros {
    public static List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        getStrings(n, "", ans);
        return ans;
    }

    private static void getStrings(int n, String s, List<String> ans) {
        if (n == 0) {
            ans.add(s.toString());
            return;
        }
        getStrings(n - 1, s + "1", ans);
        if (s.length() == 0 || s.charAt(s.length() - 1) != '0') {
            getStrings(n - 1, s + "0", ans);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(validStrings(n));
        // [111, 110, 101, 011, 010]
    }
}
