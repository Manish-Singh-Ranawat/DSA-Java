// Add one to a number represented as Linked List - https://www.naukri.com/code360/problems/add-one-to-a-number-represented-as-linked-list_920557

// You're given a positive integer represented in the form of a singly linked-list of digits. The length of the number is 'n'.

// Add 1 to the number, i.e., increment the given number by one.

// The digits are stored such that the most significant digit is at the head of the linked list and the least significant digit is at the tail of the linked list.

// Input: Initial Linked List: 1 -> 5 -> 2
// Output: Modified Linked List: 1 -> 5 -> 3
// Explanation: Initially the number is 152. After incrementing it by 1, the number becomes 153.

// Following is the linkedList class structure:
class Node {
    int data;
    Node next;

    public Node(int data) {
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

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }

}
// --------------------------

public class AddOneToLL {
    public static Node addOne(Node head) {
        Node temp = head;
        int carry = helper(temp);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static int helper(Node head) {
        if (head == null) {
            return 1;
        }
        int carry = helper(head.next);
        head.data = head.data + carry;
        if (head.data < 10) {
            return 0;
        }
        head.data = 0;
        return 1;
    }

    public static void main(String[] args) {
        Node head = Node.constructLL(new int[] { 1, 5, 2 });
        head = addOne(head);
        Node.print(head);
        // 1 -> 5 -> 3 -> null
    }
}
