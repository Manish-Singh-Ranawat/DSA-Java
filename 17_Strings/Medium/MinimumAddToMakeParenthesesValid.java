// Minimum Add to Make Parentheses Valid - https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

// A parentheses string is valid if and only if:
// - It is the empty string,
// - It can be written as AB (A concatenated with B), where A and B are valid strings, or
// - It can be written as (A), where A is a valid string.

// You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

// For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".

// Return the minimum number of moves required to make s valid.

// Input: s = "())"
// Output: 1

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                st.push('(');
            else {
                if (!st.isEmpty())
                    st.pop();
                else
                    ans++;
            }
        }
        return ans + st.size();
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
        // 1
    }
}