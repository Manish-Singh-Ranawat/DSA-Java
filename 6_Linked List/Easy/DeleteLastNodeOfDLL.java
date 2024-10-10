// Delete Last Node of a Doubly Linked List - https://www.naukri.com/code360/problems/delete-last-node-of-a-doubly-linked-list_8160469

// A doubly-linked list is a data structure that consists of sequentially linked nodes, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.

// Given a doubly-linked list, delete the node at the end of the doubly linked list.

// Note: You need not print anything. You’re given the head of the linked list, just return the head of the modified list.

// Input: Linked List:  4 <-> 10 <-> 3 <-> 5 <-> 20
// Output: Modified Linked List: 4 <-> 10 <-> 3 <-> 5
// Explanation: The last node having ‘data’ = 20 is removed from the linked list.

// Following is the class structure of the Node class:
class Node {
    public int data;
    public Node next;
    public Node prev;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public static Node constructDLL(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        return head;
    }

    public static void print(Node head) {
        Node tail = head;
        while (tail != null) {
            System.out.print(tail.data + " <-> ");
            tail = tail.next;
        }
        System.out.print("null \n");
    }
};
// -------------------------------

public class DeleteLastNodeOfDLL {
    public static Node deleteLastNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 10, 3, 5, 20 };
        Node head = Node.constructDLL(arr);
        head = deleteLastNode(head);
        Node.print(head);
        // 4 <-> 10 <-> 3 <-> 5 <-> null
    }
}
