// Introduction To Doubly Linked List - https://www.naukri.com/code360/problems/introduction-to-doubly-linked-list_8160413

// You are given an array ‘Arr’ of size ‘N’ consisting of positive integers.
// Your task is to make a doubly linked list from the array and return the head of the linked list.

// Here, the head of the doubly linked list is the first element of the array, and the tail of the doubly linked list is the last element.

// Note: A doubly linked list is one in which it is possible to access the next and the previous nodes from a node in the linked list (if they exist).

// Input: ‘N’ = 4, ‘Arr’ = [4, 2, 5, 1]
// Output: 4 2 5 1
// Explanation: Doubly Linked List for the array ‘Arr’ = [4, 2, 5, 1] is 4 <-> 2 <-> 5 <-> 1.

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

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }
};
// ------------------------------------------------

public class ArrayToDoublyLinkedList {
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

    public static void main(String[] args) {
        int arr[] = { 4, 2, 5, 1 };
        Node head = constructDLL(arr);
        Node.print(head);
        // 4 <-> 2 <-> 5 <-> 1 <-> null
    }
}
