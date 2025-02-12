// Generate Parentheses - https://leetcode.com/problems/generate-parentheses/description/

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, "", ans);
        return ans;
    }

    private static void helper(int n, int open, int close, String s, List<String> ans) {
        if (s.length() == n * 2) {
            ans.add(s.toString());
            return;
        }
        if (open < n) {
            helper(n, open + 1, close, s + "(", ans);
        }
        if (close < open) {
            helper(n, open, close + 1, s + ")", ans);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
        // [((())), (()()), (())(), ()(()), ()()()]
    }
}
