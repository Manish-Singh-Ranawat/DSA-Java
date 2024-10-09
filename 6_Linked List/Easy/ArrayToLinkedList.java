// Introduction To Linked List - https://www.naukri.com/code360/problems/introduction-to-linked-list_8144737

// You are given an array ‘Arr’ of size ‘N’ consisting of positive integers.
// Make a linked list from the array and return the head of the linked list.

// The head of the linked list is the first element of the array, and the tail of the linked list is the last element.
// In the output, you will see the elements of the linked list made by you.

// Input: ‘Arr’ = [4, 2, 5, 1]
// Output: 4 2 5 1
// Explanation: Linked List for the array ‘Arr’ = [4, 2, 5, 1] is 4 -> 2 -> 5 -> 1.

// Following is the class structure of the Node class :
class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }
};
// ----------------------------------

public class ArrayToLinkedList {
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

    public static void main(String[] args) {
        int arr[] = { 4, 2, 5, 1 };
        Node head = constructLL(arr);
        Node.print(head);
        // 4 -> 2 -> 5 -> 1 -> null
    }
}
