// PostFix To Prefix - https://www.naukri.com/code360/problems/postfix-to-prefix_1788455

// You are given a string denoting a valid Postfix expression containing ‘+’, ’-’, ’*’, ‘/’ and lowercase letters.
// Convert the given Postfix expression into a Prefix expression.

// Note : Expression contains lowercase English letters, ‘+’, ‘-’, ‘*’, and  ‘/’. 

// Input: abc*+
// Output: +a*bc
// Explanation : For the given postfix expression, infix expression is a+b*c. And it's corresponding prefix expression is +a*bc.

import java.util.Stack;

public class PostfixToPrefix {
    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();
        char[] postfixArray = postfix.toCharArray();
        int n = postfixArray.length;
        for (int i = 0; i < n; i++) {
            char current = postfixArray[i];
            if (Character.isLetterOrDigit(current)) {
                stack.push(Character.toString(current));
            } else {
                String firstTop = stack.pop();
                String secondTop = stack.pop();
                String exp = current + secondTop + firstTop;
                stack.push(exp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "abc*+";
        System.out.println(postfixToPrefix(postfix));
        // +a*bc
    }
}
