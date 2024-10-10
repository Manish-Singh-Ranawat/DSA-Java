// Insertion In Doubly Linked List - https://www.naukri.com/code360/problems/insertion-in-doubly-linked-list_4609682

// You are given a Doubly linked list, where every node in the linked list contains two pointers ‘next’ and ‘prev’ which point to the next node and previous node in the list respectively. All nodes have some positive integer value associated with them. Your task is to insert an integer value ‘VAL’ in the linked list at a given position ‘K’.

// Note: The position given will always be less than or equal to the length of the linked list.
// Assume that the Indexing for the linked list starts from 0.

// Input :‘K’ = 3, ‘VAL’ = 4, list = [1, 2, 3]
// Output: [1, 2, 3, 4]
// Explanation: The ‘VAL’ = 4, is inserted at end of the doubly linked list.

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
// -------------------------------------

public class InsertNodeAtIndexInDLL {
    public static Node insert(int k, int val, Node head) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        if (k == 0) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        Node temp = head;
        int i = 0;
        while (temp != null && i != (k - 1)) {
            i++;
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        Node head = Node.constructDLL(arr);
        int k = 3;
        int val = 4;
        head = insert(k, val, head);
        Node.print(head);
        // 1 <-> 2 <-> 3 <-> 4 <-> null
    }
}
