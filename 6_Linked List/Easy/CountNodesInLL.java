// Count nodes of linked list - https://www.naukri.com/code360/problems/count-nodes-of-linked-list_5884

// Given the head of a singly linked list of integers, find and return its length.

// Input : 3 4 5 2 6 1 9 
// Output : 7
// Explanation : The number of nodes in the given linked list is 7.
// Hence we return 7.

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
// -----------------------------

public class CountNodesInLL {
    public static int length(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 2, 6, 1, 9 };
        Node head = Node.constructLL(arr);
        System.out.println(length(head));
        // 7
    }
}
