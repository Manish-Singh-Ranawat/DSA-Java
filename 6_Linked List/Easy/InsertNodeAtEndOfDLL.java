// Insert at end of Doubly Linked List - https://www.naukri.com/code360/problems/insert-at-end-of-doubly-linked-list_8160464

// A doubly-linked list is a data structure that consists of sequentially linked nodes, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.

// Given a doubly-linked list and a value ‘k’, insert a node having value ‘k’ at the end of the doubly linked list.

// Note: You need not print anything. You’re given the head of the linked list. Return the head of the modified list.

// Input: Linked List: 4 <-> 10 <-> 3 <-> 5 and ‘k’ = 20
// Output: Modified Linked List: 4 <-> 10 <-> 3 <-> 5 <-> 20
// Explanation: A new node having value ‘k’ = 20 is inserted at the end of the linked list.

// Following is the class structure of the Node class:
class Node {
    public int data;
    public Node next;
    public Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public static Node constructDLL(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }
};
// ----------------------------------

public class InsertNodeAtEndOfDLL {
    public static Node insertAtTail(Node head, int k) {
        Node newNode = new Node(k);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 10, 3, 5 };
        Node head = Node.constructDLL(arr);
        int k = 20;
        head = insertAtTail(head, k);
        Node.print(head);
        // 4 <-> 10 <-> 3 <-> 5 <-> 20 <-> null
    }
}
