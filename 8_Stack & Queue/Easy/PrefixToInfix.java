// Prefix to Infix - https://www.naukri.com/code360/problems/prefix-to-infix_1215000

// You are given a string denoting a valid Prefix expression containing ‘+’, ’-’, ’*’, ‘/’ and lowercase letters.
// Convert the given Prefix expression into an Infix expression.

// Note: Surround every expression with a pair of parentheses “()”.

// Input: /-ab+-cde
// Output: ((a-b)/((c-d)+e))
// Explanation: The expression “((a-b)/((c-d)+e))” in infix is equivalent to “/-ab+-cde” in prefix.

import java.util.Stack;

public class PrefixToInfix {
    public static String prefixToInfixConversion(String prefix) {
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
                String exp = "(" + firstTop + Character.toString(current) + secondTop + ")";
                stack.push(exp);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String prefix = "/-ab+-cde";
        System.out.println(prefixToInfixConversion(prefix));
        // ((a-b)/((c-d)+e))
    }
}
