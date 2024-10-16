// Rotate List - https://leetcode.com/problems/rotate-list/description/

// Given the head of a linked list, rotate the list to the right by k places.

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

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
// -----------------------------------------------------------

public class RotateLL {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        tail.next = head;
        ListNode lastNode = getNthNode(head, n - k);
        head = lastNode.next;
        lastNode.next = null;
        return head;
    }

    public static ListNode getNthNode(ListNode head, int N) {
        ListNode temp = head;
        while (temp != null && N > 1) {
            N--;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        int k = 2;
        ListNode head = ListNode.constructLL(new int[] { 1, 2, 3, 4, 5 });
        head = rotateRight(head, k);
        ListNode.print(head);
        // 4 -> 5 -> 1 -> 2 -> 3 -> null
    }
}
