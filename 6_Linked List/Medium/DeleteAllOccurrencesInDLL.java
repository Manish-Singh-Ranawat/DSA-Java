// Delete all occurrences of a given key in a doubly linked list - https://www.naukri.com/code360/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461

// A doubly-linked list is a data structure that consists of sequentially linked nodes, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.

// You’re given a doubly-linked list and a key 'k'.
// Delete all the nodes having data equal to ‘k’.

// Input: Linked List: 10 <-> 4 <-> 10 <-> 3 <-> 5 <-> 20 <-> 10 and ‘k’ = 10
// Output: Modified Linked List: 4 <-> 3 <-> 5 <-> 20
// Explanation: All the nodes having ‘data’ = 10 are removed from the linked list.

// Following is the linkedList class structure:
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
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
// ---------------------------

public class DeleteAllOccurrencesInDLL {
    public static Node deleteAllOccurrences(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                if (temp == head) {
                    head = head.next;
                }
                Node prevNode = temp.prev;
                Node nextNode = temp.next;
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int k = 10;
        Node head = Node.constructDLL(new int[] { 10, 4, 10, 3, 5, 20, 10 });
        head = deleteAllOccurrences(head, k);
        Node.print(head);
        // 4 <-> 3 <-> 5 <-> 20 <-> null
    }
}
