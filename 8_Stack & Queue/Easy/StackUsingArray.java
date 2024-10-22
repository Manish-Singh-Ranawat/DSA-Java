// Stack Implementation Using Array -  https://www.naukri.com/code360/problems/stack-implementation-using-array_3210209

// Stack is a data structure that follows the LIFO (Last in First out) principle. Design and implement a stack to implement the following functions:

// 1. Push(num): Push the given number in the stack if the stack is not full.
// 2. Pop: Remove and print the top element from the stack if present, else print -1.
// 3. Top: Print the top element of the stack if present, else print -1.
// 4. isEmpty: Print 1 if the stack is empty, else print 0.
// 5. isFull: Print 1 if the stack is full, else print 0.

class Stack {
    int stack[];
    int top;
    int capacity;

    Stack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    public void push(int num) {
        if (isFull() == 1) {
            System.out.println("Stack is full, cannot push " + num);
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop() {
        return isEmpty() == 1 ? -1 : stack[top--];
    }

    public int top() {
        return isEmpty() == 1 ? -1 : stack[top];
    }

    public int isEmpty() {
        return top == -1 ? 1 : 0;
    }

    public int isFull() {
        return top == capacity - 1 ? 1 : 0;
    }

    public void print() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        // Create a stack of capacity 3
        Stack st = new Stack(3);

        // Push elements to the stack
        st.push(1); // Pushing 1
        st.push(2); // Pushing 2
        st.push(3); // Pushing 3

        // Try pushing when stack is full
        st.push(4); // Stack is full, this should print a message

        // Print the stack elements
        st.print(); // Output: 1 2 3

        // Pop the top element
        System.out.println("Popped: " + st.pop()); // Output: Popped: 3

        // Check the top element
        System.out.println("Top element: " + st.top()); // Output: Top element: 2

        // Check if stack is empty
        System.out.println("Is stack empty? " + st.isEmpty()); // Output: Is stack empty? 0

        // Check if stack is full
        System.out.println("Is stack full? " + st.isFull()); // Output: Is stack full? 0

        // Pop remaining elements
        st.pop();
        st.pop();

        // Check if stack is empty now
        System.out.println("Is stack empty? " + st.isEmpty()); // Output: Is stack empty? 1

        // Try popping from an empty stack
        System.out.println("Popped: " + st.pop()); // Output: Popped: -1
    }
}
