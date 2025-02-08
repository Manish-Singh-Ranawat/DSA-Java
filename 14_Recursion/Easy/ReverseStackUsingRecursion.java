// Reverse Stack Using Recursion - https://www.naukri.com/code360/problems/reverse-stack-using-recursion_631875?leftPanelTabValue=PROBLEM

// Reverse a given stack of 'N' integers using recursion. You are required to make changes in the input parameter itself.

// Note: You are not allowed to use any extra space other than the internal stack space used due to recursion.

// Input: [1, 2, 3, 4, 5] 
// Output: [5, 4, 3, 2, 1]

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int cur = stack.pop();
        reverseStack(stack);
        insert(stack, cur);
    }

    private static void insert(Stack<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }
        int top = stack.pop();
        insert(stack, num);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack); // [1, 2, 3, 4, 5]
        reverseStack(stack);       //              | -> top
        System.out.println(stack); // [5, 4, 3, 2, 1]
    }
}
