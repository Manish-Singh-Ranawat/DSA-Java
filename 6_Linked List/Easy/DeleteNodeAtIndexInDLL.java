// Deletion In Doubly Linked List - https://www.naukri.com/code360/problems/deletion-in-doubly-linked-list_4609672

// You are given a Doubly Linked List of ‘N’ positive integers. Your task is to delete a node at position ‘POS’ in the linked list.

// Note: Assume that the Indexing for the linked list starts from 0.

// Input: ‘N’ = 5, 'LIST' = [1, 1, 2, 3, 4], ‘POS’ = 1.
// Output: 1 < - > 2 < - > 3 < - > 4 
// Here in the given list, we can see that the node at position 1 is deleted.

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
// --------------------------------

public class DeleteNodeAtIndexInDLL {
    static Node deleteNode(Node head, int pos) {
        if (head == null || head.next == null) {
            return null;
        }
        if (pos == 0) {
            head = head.next;
            head.prev = null;
            return head;
        }
        int i = 0;
        Node temp = head;
        while (temp != null && i != pos) {
            i++;
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        Node prevNode = temp.prev;
        Node nextNode = temp.next;
        prevNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4 };
        Node head = Node.constructDLL(arr);
        int pos = 1;
        head = deleteNode(head, pos);
        Node.print(head);
    }
}
