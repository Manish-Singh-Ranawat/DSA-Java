// Sort a Stack - https://www.naukri.com/code360/problems/sort-a-stack_985275?leftPanelTabValue=PROBLEM

// You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.

// We can only use the following functions on this stack S.

// is_empty(S) : Tests whether stack is empty or not.
// push(S) : Adds a new element to the stack.
// pop(S) : Removes top element from the stack.
// top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.

// Note :
// 1) Use of any loop constructs like while, for..etc is not allowed. 
// 2) The stack may contain duplicate integers.
// 3) The stack may contain any integer i.e it may either be negative, positive or zero.

// Input : [3, -7, 9, -2, 5]
// Output : [-7, -2, 3, 5, 9]
// Explanation : 9 Is the largest element, hence it’s present at the top. Similarly 5>3, 3>-2 and -7 being the smallest element is present at the last. 

import java.util.Stack;

public class SortStackUsingRecursion {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int cur = stack.pop();
        sortStack(stack);
        insert(stack, cur);
    }

    private static void insert(Stack<Integer> stack, int num) {
        if (stack.isEmpty() || stack.peek() <= num) {
            stack.push(num);
            return;
        }
        int top = stack.pop();
        insert(stack, num);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(-7);
        stack.push(9);
        stack.push(-2);
        stack.push(5);
        System.out.println(stack); // [3, -7, 9, -2, 5]
        sortStack(stack);          //                | -> top
        System.out.println(stack); // [-7, -2, 3, 5, 9]
    }
}
