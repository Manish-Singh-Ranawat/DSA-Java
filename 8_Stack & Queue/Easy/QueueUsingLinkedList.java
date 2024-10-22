// Implement Queue Using Linked List - https://www.naukri.com/code360/problems/implement-queue-using-linked-list_8161235

// You must implement the Queue data structure using a Singly Linked List.

// Create a class named 'Queue' which supports the following operations():
// 1. Constructor: It initializes the data members as required.
// 2. enqueue(data): This function should take one argument of type integer. It enqueues the element into the queue.
// 3. dequeue(): It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.
// 4. front(): It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.
// 5. isEmpty(): It returns a boolean value indicating whether the queue is empty or not.

// Class structure for a Node in the linked list
class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
};

class Queue {
    Node front;
    Node rear;
    int size;

    Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        Node deleted = front;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return deleted.data;
    }

    public int front() {
        return size == 0 ? -1 : front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class QueueUsingLinkedList {

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements into the queue
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);

        // Print the queue
        queue.print(); // Output: Queue elements: 5 10 15

        // Dequeue an element and print the queue
        System.out.println("Popped: " + queue.dequeue()); // Output: Popped: 5
        queue.print(); // Output: Queue elements: 10 15

        // Check the front element
        System.out.println("Top element: " + queue.front()); // Output: Top element: 10

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

        // Dequeue all elements
        queue.dequeue();
        queue.dequeue();

        // Check the queue after dequeuing all elements
        queue.print(); // Output: Queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true
    }
}
