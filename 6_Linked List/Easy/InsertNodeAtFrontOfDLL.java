// Insert At The Front of a Doubly Linked List - https://www.naukri.com/code360/problems/insert-at-the-front-of-a-doubly-linked-list_9697366

// You are given a doubly-linked list of length ‘n’.
// You must insert a node having the value ‘k’ in the front of the doubly linked list.

// Note: A doubly-linked list is a data structure that consists of sequentially linked records, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.

// Input: Linked List: 4 <-> 10 <-> 3 <-> 5 and ‘k’ = 20
// Output: Modified Linked List: 20 <-> 4 <-> 10 <-> 3 <-> 5
// Explanation: A new node having value ‘k’ = 20 is inserted at the front of the linked list.

// Following is the class structure of the Node class:
class Node {
    public int value;
    public Node next;
    public Node prev;

    Node(int value) {
        this.value = value;
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
            System.out.print(temp.value + " <-> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }
}
// -----------------------------------

public class InsertNodeAtFrontOfDLL {
    public static Node insertAtFront(Node head, int k) {
        Node newNode = new Node(k);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 10, 3, 5 };
        Node head = Node.constructDLL(arr);
        int k = 20;
        head = insertAtFront(head, k);
        Node.print(head);
        // 20 <-> 4 <-> 10 <-> 3 <-> 5 <-> null
    }
}
