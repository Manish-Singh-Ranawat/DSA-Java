// Min Stack - https://leetcode.com/problems/min-stack/description/

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

// Input :
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output :
// [null,null,null,null,-3,null,0,-2]

// Explanation :
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2

import java.util.Stack;

public class MinStack {
    long min;
    Stack<Long> minStack;

    public MinStack() {
        this.min = Long.MAX_VALUE;
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        long value = (long) val;
        if (minStack.isEmpty()) {
            min = value;
            minStack.push(value);
        } else {
            if (value < min) {
                long modifiedVal = 2 * value - min;
                minStack.push(modifiedVal);
                min = value;
            } else {
                minStack.push(value);
            }
        }
    }

    public void pop() {
        if (minStack.isEmpty()) {
            return;
        }
        long top = minStack.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = minStack.peek();
        return top > min ? (int) top : (int) min;
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output : -3
        minStack.pop();
        System.out.println(minStack.top()); // Output : 0
        System.out.println(minStack.getMin()); // Output : -2
    }
}
