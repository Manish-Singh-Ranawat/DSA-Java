// Reverse Linked List - https://leetcode.com/problems/reverse-linked-list/description/

// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

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
// --------------------------------

public class ReverseLL {
    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prevNode = null;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        return prevNode;
    }

    public static ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode frontNode = head.next;
        frontNode.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.constructLL(arr);
        head = reverseList(head);
        // head = reverseListUsingRecursion(head);
        ListNode.print(head);
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
    }
}
