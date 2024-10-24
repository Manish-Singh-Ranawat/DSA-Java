// You are given a string denoting a valid Prefix expression containing ‘+’, ’-’, ’*’, ‘/’ and lowercase letters.
// Convert the given Prefix expression into a Postfix expression.

// Note: Expression contains lowercase English letters, ‘+’, ‘-’, ‘*’, and  ‘/’.

// Input: +a*bc
// Output: abc*+
// Explanation: For the given prefix expression, infix expression is a+b*c. And its corresponding postfix expression is abc*+.

import java.util.Stack;

public class PrefixToPostfix {
    public static String prefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();
        char[] prefixArray = prefix.toCharArray();
        int n = prefixArray.length;
        for (int i = n - 1; i >= 0; i--) {
            char current = prefixArray[i];
            if (Character.isLetterOrDigit(current)) {
                stack.push(Character.toString(current));
            } else {
                String firstTop = stack.pop();
                String secondTop = stack.pop();
                String exp = firstTop + secondTop + current;
                stack.push(exp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "+a*bc";
        System.out.println(prefixToPostfix(prefix));
        // abc*+
    }
}
