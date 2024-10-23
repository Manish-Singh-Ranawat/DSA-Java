// Infix To Postfix - https://www.naukri.com/code360/problems/infix-to-postfix_1382146

// You are given a string 'exp' which is a valid infix expression.
// Convert the given infix expression to postfix expression.

// Note :
// Infix notation is a method of writing mathematical expressions in which operators are placed between operands. For example, "3 + 4" represents the addition of 3 and 4.

// Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands. For example, "3 4 +" represents the addition of 3 and 4.

// Expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’. 

// Input: exp = ‘3+4*8’
// Output: 348*+
// Explanation : Here multiplication is performed first and then the addition operation. Hence postfix expression is  348*+.

import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String exp) {
        StringBuilder postfix = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (char it : exp.toCharArray()) {
            if (Character.isLetterOrDigit(it)) {
                postfix.append(it);
            } else if (it == '(') {
                stack.push(it);
            } else if (it == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && operatorPriority(it) <= operatorPriority(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(it);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static int operatorPriority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '/' || ch == '*') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String exp = "3+4*8";
        System.out.println(infixToPostfix(exp));
        // 348*+
    }
}
