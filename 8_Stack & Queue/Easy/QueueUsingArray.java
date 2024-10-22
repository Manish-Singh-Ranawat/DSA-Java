// Implement a Queue - https://www.naukri.com/code360/problems/queue-using-array-or-singly-linked-list_2099908

// Implement a Queue Data Structure specifically to store integer data using an array.

// You need to implement the following public functions :
// 1. Constructor: It initializes the data members as required.
// 2. enqueue(data): This function should take one argument of type integer. It enqueues the element into the queue.
// 3. dequeue(): It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.
// 4. front(): It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.
// 5. isEmpty(): It returns a boolean value indicating whether the queue is empty or not.

class Queue {
    int queue[];
    int front;
    int rear;
    int size;
    int capacity;

    Queue(int capacity) {
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue is full, cannot enqueue.");
            return;
        }
        if (rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        queue[rear] = data;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int deleted = queue[front];
        if (size == 1) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return deleted;
    }

    int front() {
        return isEmpty() ? -1 : queue[front];
    }

    public void print() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }
}

public class QueueUsingArray {

    public static void main(String[] args) {
        // Create a queue with a capacity of 5
        Queue queue = new Queue(5);

        // Enqueue elements into the queue
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);

        // Print the queue
        queue.print(); // Output: 5 6 7 8 9

        // Dequeue an element and print the queue
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 5
        queue.print(); // Output: 6 7 8 9

        // Check the front element
        System.out.println("Front element: " + queue.front()); // Output: Front element: 6

        // Enqueue another element
        queue.enqueue(10);
        queue.print(); // Output: 6 7 8 9 10

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

        // Dequeue all elements and print the queue after each operation
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
            queue.print();
        }

        // Try to dequeue from an empty queue
        System.out.println("Dequeued from empty queue: " + queue.dequeue()); // Output: -1
    }
}
