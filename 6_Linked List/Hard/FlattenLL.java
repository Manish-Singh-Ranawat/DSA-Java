// Flatten A Linked List - https://www.naukri.com/code360/problems/flatten-a-linked-list_1112655

// You are given a linked list containing 'n' 'head' nodes, where every node in the linked list contains two pointers:
// (1) ‘next’ which points to the next node in the list
// (2) ‘child’ pointer to a linked list where the current node is the head.

// Each of these child linked lists is in sorted order and connected by 'child' pointer.
// Your task is to flatten this linked such that all nodes appear in a single layer or level in a 'sorted order'.

// Input: 1 → 4 → 7 → 9 → 20 → null
//        |   |   |   |    
//        2   5   8  12
//        |   |
//        3   6

// Output:
// 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 12 → 20 → null.

// Explanation:
// The returned linked list should be in a sorted order. All the elements in this returned linked list are connected by 'child' pointers and 'next' pointers point to null.

// Following is the class structure of the Node class:
class Node {
    public int data;
    public Node next;
    public Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
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

    public static void addChildNodes(Node parent, int arr[]) {
        Node temp = parent;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Node child = new Node(arr[i]);
            temp.child = child;
            temp = temp.child;
        }
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.child;
        }
        System.out.print("null \n");
    }
}
// -----------------------------------------------------------

public class FlattenLL {
    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = flattenLinkedList(head.next);
        head = merge(head, head.next);
        return head;
    }

    public static Node merge(Node first, Node second) {
        if (first == null) {
            second.next = null;
            return second;
        }
        if (second == null) {
            first.next = null;
            return first;
        }
        Node merged;
        if (first.data < second.data) {
            merged = first;
            merged.child = merge(first.child, second);
        } else {
            merged = second;
            merged.child = merge(first, second.child);
        }
        merged.next = null;
        return merged;
    }

    public static void main(String[] args) {
        Node head = Node.constructLL(new int[] { 1, 4, 7, 9, 20 });
        Node.addChildNodes(head, new int[] { 2, 3 });
        Node.addChildNodes(head.next, new int[] { 5, 6 });
        Node.addChildNodes(head.next.next, new int[] { 8 });
        Node.addChildNodes(head.next.next.next, new int[] { 12 });

        Node flattenedList = flattenLinkedList(head);
        Node.print(flattenedList);
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 12 -> 20 -> null
    }
}