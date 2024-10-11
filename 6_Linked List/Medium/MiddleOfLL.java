// Middle of the Linked List - https://leetcode.com/problems/middle-of-the-linked-list/description/

// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode constructLL(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            ListNode newNode = new ListNode(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }
}
// ---------------------------------------

public class MiddleOfLL {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.constructLL(arr);
        head = middleNode(head);
        ListNode.print(head);
        // 3 -> 4 -> 5 -> null
    }
}
