// Valid Parenthesis String - https://leetcode.com/problems/valid-parenthesis-string/description/

// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

// Input: s = "()"
// Output: true

// Input: s = "(*)"
// Output: true

// Input: s = "(*))"
// Output: true

public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (char it : s.toCharArray()) {
            if (it == '(') {
                min++;
                max++;
            } else if (it == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (min < 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));
        // true
    }
}
