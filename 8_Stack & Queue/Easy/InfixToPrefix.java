// Infix To Prefix Conversion

// You are given a string 'exp' which is a valid infix expression.
// Convert the given infix expression to prefix expression.

// Note :
// Infix notation is a method of writing mathematical expressions in which operators are placed between operands. For example, "3 + 4" represents the addition of 3 and 4.

// Prefix notation is a method of writing mathematical expressions in which operators are placed before the operands. For example, "+ 3 4" represents the addition of 3 and 4.

// Expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’.

// Input: str = ‘x+y*z/w+u’
// Output: ++x/*yzwu
// Explanation : The prefix expression for the given infix expression is ++x/*yzwu

import java.util.Stack;

public class InfixToPrefix {

    public static String infixToPrefix(String exp) {
        int n = exp.length();
        exp = reverse(exp);
        exp = changeBrackets(exp);
        exp = infixToPostfix(exp);
        exp = reverse(exp);
        return exp;
    }

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
                // In the regular infix to postfix conversion, we use <= for operator
                // precedence,
                // but here, we use < to maintain correct precedence handling.
                while (!stack.isEmpty() && operatorPriority(it) < operatorPriority(stack.peek())) {
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

    public static String reverse(String exp) {
        char[] charArray = exp.toCharArray();
        int low = 0;
        int high = charArray.length - 1;
        while (low < high) {
            char temp = charArray[low];
            charArray[low] = charArray[high];
            charArray[high] = temp;
            low++;
            high--;
        }
        return new String(charArray);
    }

    public static String changeBrackets(String exp) {
        char[] charArray = exp.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                charArray[i] = ')';
            } else if (charArray[i] == ')') {
                charArray[i] = '(';
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "x+y*z/w+u";
        System.out.println(infixToPrefix(str));
        // Output: ++x/*yzwu
    }
}
