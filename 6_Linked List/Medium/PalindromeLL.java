// Palindrome Linked List - https://leetcode.com/problems/palindrome-linked-list/description/

// Given the head of a singly linked list, return true if it is a  palindrome or false otherwise.

// Input: head = [1,2,2,1]
// Output: true

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
}
// ------------------------------------------

public class PalindromeLL {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead); // restore to original form
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead); // restore to original form
        return true;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.constructLL(new int[] { 1, 2, 2, 1 });
        System.out.println(isPalindrome(head));
        // true
    }
}
