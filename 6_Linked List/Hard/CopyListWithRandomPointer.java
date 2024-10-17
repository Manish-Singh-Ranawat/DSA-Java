// Copy List with Random Pointer - https://leetcode.com/problems/copy-list-with-random-pointer/description/

// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node.
// Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
// None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.

// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node constructLL(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node[] nodes = new Node[arr.length];

        // Create all nodes
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i][0]);
        }

        // Connect next pointers
        for (int i = 0; i < arr.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Connect random pointers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] != -1) { // Use -1 to represent null
                nodes[i].random = nodes[arr[i][1]];
            }
        }

        return nodes[0];
    }

    public static void print(Node head) {
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print("[" + temp.val + ",");
            if (temp.random == null) {
                System.out.print("null]");
            } else {
                // Find the index of the random node
                Node search = head;
                int index = 0;
                while (search != temp.random) {
                    search = search.next;
                    index++;
                }
                System.out.print(index + "]");
            }
            if (temp.next != null) {
                System.out.print(",");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }
}
// -------------------------------------

public class CopyListWithRandomPointer {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        head = insertCopyInBetween(head);
        head = connectRandomPointers(head);
        return getDeepCopy(head);
    }

    public static Node insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        return head;
    }

    public static Node connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copy = temp.next;
            copy.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }
        return head;
    }

    public static Node getDeepCopy(Node head) {
        Node copy = new Node(-1);
        Node copyHead = copy;
        Node temp = head;
        while (temp != null) {
            copy.next = temp.next;
            copy = copy.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return copyHead.next;
    }

    public static void main(String[] args) {
        int[][] input = { { 7, -1 }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } };
        Node head = Node.constructLL(input);
        Node copyHead = copyRandomList(head);
        Node.print(copyHead);
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
    }
}
