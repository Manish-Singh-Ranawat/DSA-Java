// Find length of Loop - https://www.naukri.com/code360/problems/find-length-of-loop_8160455

// You’re given a linked list. The last node might point to null, or it might point to a node in the list, thus forming a cycle.

// Find out whether the linked list has a cycle or not, and the length of the cycle if it does.
// If there is no cycle, return 0, otherwise return the length of the cycle.

// Input: Linked List: 4 -> 10 -> 3 -> 5 -> 10(at position 2)
// Output: Length of cycle = 3
// Explanation: The cycle is 10, 3, 5.

// Following is the linkedList class structure:
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
// ------------------------------------

public class LengthOfLoopInLL {
    public static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int len = 1;
                fast = fast.next;
                while (slow != fast) {
                    len++;
                    fast = fast.next;
                }
                return len;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        Node second = new Node(10);
        Node third = new Node(3);
        Node fourth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Create a loop

        System.out.println(lengthOfLoop(head));
        // 3
    }
}
