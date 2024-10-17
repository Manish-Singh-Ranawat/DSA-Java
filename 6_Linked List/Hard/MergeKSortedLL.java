// Merge k Sorted Lists - https://leetcode.com/problems/merge-k-sorted-lists/description/

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

import java.util.PriorityQueue;

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
        ListNode dummy = head;
        for (int i = 1; i < n; i++) {
            ListNode newNode = new ListNode(arr[i]);
            dummy.next = newNode;
            dummy = newNode;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode dummy = head;
        while (dummy != null) {
            System.out.print(dummy.val + " -> ");
            dummy = dummy.next;
        }
        System.out.print("null \n");
    }
}
// -------------------------------------------------

public class MergeKSortedLL {
    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            dummy.next = node;
            dummy = dummy.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.constructLL(new int[] { 1, 4, 5 });
        ListNode head2 = ListNode.constructLL(new int[] { 1, 3, 4 });
        ListNode head3 = ListNode.constructLL(new int[] { 2, 6 });
        ListNode lists[] = { head1, head2, head3 };
        ListNode merged = mergeKLists(lists);
        ListNode.print(merged);
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null
    }
}
