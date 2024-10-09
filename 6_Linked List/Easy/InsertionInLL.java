// Insertion In A Singly Linked List - https://www.naukri.com/code360/problems/insertion-in-a-singly-linked-list_4609646

// You are given a Singly Linked List of ‘N’ positive integers. Your task is to add a node having the value ‘VAL’ at position ‘POS’ in the linked list.

// Note: Assume that the Indexing for the linked list starts from 0.

// Input: ‘N’ = 5, 'LIST' = [1, 1, 2, 3, 4, -1], ‘VAL’ = 2, ‘POS’ = 1.
// Output: 1 -> 2 -> 1 -> 2 -> 3 -> 4 
// Here in the given list we can see that the node having value 2 is inserted at position 1.

// Following is the linkedList class structure:
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public static Node constructLL(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }
}
// -------------------

public class InsertionInLL {
    public static Node insert(Node head, int n, int pos, int val) {
        Node newNode = new Node(val);
        if (head == null || pos == 0) {
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        int i = 0;
        while (temp != null && i != (pos - 1)) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4 };
        int n = arr.length;
        Node head = Node.constructLL(arr);
        head = insert(head, n, 1, 2);
        Node.print(head);
        // 1 -> 2 -> 1 -> 2 -> 3 -> 4 -> null
    }
}
