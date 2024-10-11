// Reverse A Doubly Linked List - https://www.naukri.com/code360/problems/reverse-a-doubly-linked-list_1116098

// You are given a doubly-linked list of size 'N', consisting of positive integers. Now your task is to reverse it and return the head of the modified list.

// Note: A doubly linked list is a kind of linked list that is bidirectional, meaning it can be traversed in both forward and backward directions.

// Input: 4 , 4 3 2 1
// This means you have been given doubly linked list of size 4 = 4 <-> 3 <-> 2 <-> 1.

// Output: 1 2 3 4
// This means after reversing the doubly linked list it becomes 1 <-> 2 <-> 3 <-> 4.

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
// ----------------------------------------

public class ReverseDLL {
    public static Node reverseDLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node prevNode = null;
        while (temp != null) {
            temp.prev = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = temp.prev;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 1 };
        Node head = Node.constructDLL(arr);
        head = reverseDLL(head);
        Node.print(head);
        // 1 <-> 2 <-> 3 <-> 4 <-> null
    }
}
