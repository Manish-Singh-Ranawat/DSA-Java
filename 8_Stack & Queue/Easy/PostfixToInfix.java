// Postfix to Infix - https://www.naukri.com/code360/problems/postfix-to-infix_8382386

// You are given a mathematical expression in postfix notation. The expression consists of alphabets(both lowercase and uppercase) and operators.
// Convert this expression to infix notation.

// Note: Surround every expression with a pair of parentheses “()”.

// Input: ‘postfix’ = “ab+c+”
// Output: ‘infix’ = “((a+b)+c)”
// Explanation: The expression “((a+b)+c)” in infix is equivalent to “ab+c+” in postfix.

import java.util.Stack;

public class PostfixToInfix {
    public static String postToInfix(String postfix) {
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
                String exp = "(" + secondTop + Character.toString(current) + firstTop + ")";
                stack.push(exp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ab+c+";
        System.out.println(postToInfix(postfix));
        // ((a+b)+c)
    }
}
