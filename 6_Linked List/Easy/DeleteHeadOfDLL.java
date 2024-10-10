// Delete Head of a Doubly Linked List - https://www.naukri.com/code360/problems/insert-before-the-given-node-of-a-doubly-linked-list_9719100

// You are given a doubly-linked list of length ’n’ .

// Your task is to delete the head of a doubly-linked list.

// Note: A doubly-linked list is a data structure that consists of sequentially linked records, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.

// Input: 5 <-> 8 <-> 3 <-> 7 <-> 9
// Output: 8 <-> 3 <-> 7 <-> 9
// Explanation: The head of the given list is at 5. After deletion of head, new list is 8 <-> 3 <-> 7 <-> 9.

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
}
// -------------------------------

public class DeleteHeadOfDLL {
    public static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        head.prev = null;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 8, 3, 7, 9 };
        Node head = Node.constructDLL(arr);
        head = deleteHead(head);
        Node.print(head);
        // 8 <-> 3 <-> 7 <-> 9 <-> null
    }
}
