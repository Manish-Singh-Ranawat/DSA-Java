// Implement Stack With Linked List - https://www.naukri.com/code360/problems/implement-stack-with-linked-list_630475

// You must implement the Stack data structure using a Singly Linked List.

// Create a class named 'Stack' which supports the following operations(all in O(1) time):
// getSize: Returns an integer. Gets the current size of the stack
// isEmpty: Returns a boolean. Gets whether the stack is empty
// push: Returns nothing. Accepts an integer. Puts that integer at the top of the stack
// pop: Returns nothing. Removes the top element of the stack. It does nothing if the stack is empty.
// getTop: Returns an integer. Gets the top element of the stack. Returns -1 if the stack is empty

// Following is the class structure of the Node class:
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
};

class Stack {
    int size;
    Node top;

    Stack() {
        this.size = 0;
        this.top = null;
    }

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, nothing to pop.");
            return;
        }
        top = top.next;
        size--;
    }

    int getTop() {
        return isEmpty() ? -1 : top.data;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        // Create a stack
        Stack st = new Stack();

        // Push elements to the stack
        st.push(1); // Pushing 1
        st.push(2); // Pushing 2
        st.push(3); // Pushing 3

        // Print the stack
        st.print(); // Output: 3 2 1

        // Check the size of the stack
        System.out.println("Size: " + st.getSize()); // Output: Size: 3

        // Get the top element
        System.out.println("Top element: " + st.getTop()); // Output: Top element: 3

        // Pop the top element
        st.pop(); // Removes 3
        System.out.println("After pop, top element: " + st.getTop()); // Output: After pop, top element: 2

        // Print the stack again
        st.print(); // Output: 2 1

        // Check if the stack is empty
        System.out.println("Is stack empty? " + st.isEmpty()); // Output: Is stack empty? false

        // Pop remaining elements
        st.pop(); // Removes 2
        st.pop(); // Removes 1

        // Check the size of the stack after popping all elements
        System.out.println("Size: " + st.getSize()); // Output: Size: 0

        // Try popping from an empty stack
        st.pop(); // No effect
        System.out.println("Top element: " + st.getTop()); // Output: Top element: -1

        // Check if the stack is empty
        System.out.println("Is stack empty? " + st.isEmpty()); // Output: Is stack empty? true
    }
}
