// Search in a Linked List - https://www.naukri.com/code360/problems/search-in-a-linked-list_975381

// You are given a Singly Linked List of integers with a head pointer. Every node of the Linked List has a value written on it.

// Now you have been given an integer value, 'K'. Your task is to check whether a node with a value equal to 'K' exists in the given linked list. Return 1 if node exists else return 0.

// Input : 3 6 2 7 9 , k = 2
// Output : 1
// Explanation : As value 2 exists in the given linked list. So we will return 1 in this case.

// Following is the class structure of the Node class:
class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
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
}
// ---------------

public class SearchInLL {
    public static int searchInLinkedList(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int k = 2;
        int arr[] = { 3, 6, 2, 7, 9 };
        Node head = Node.constructLL(arr);
        System.out.println(searchInLinkedList(head, k));
        // 1
    }
}
