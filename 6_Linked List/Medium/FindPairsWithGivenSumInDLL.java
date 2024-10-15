// Find pairs with given sum in doubly linked list - https://www.naukri.com/code360/problems/find-pairs-with-given-sum-in-doubly-linked-list_1164172

// A doubly-linked list is a data structure that consists of sequentially linked nodes, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.

// You are given a sorted doubly linked list of size 'n', consisting of distinct positive integers, and a number 'k'.

// Find out all the pairs in the doubly linked list with sum equal to 'k'.

// Input: Linked List: 1 <-> 2 <-> 3 <-> 4 <-> 9 and 'k' = 5
// Output: (1, 4) and (2, 3)
// Explanation: There are 2 pairs in the linked list having sum 'k' = 5.

import java.util.ArrayList;
import java.util.List;

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
}

// -----------------

public class FindPairsWithGivenSumInDLL {
    public static ArrayList<int[]> findPairs(Node head, int k) {
        ArrayList<int[]> list = new ArrayList<>();
        Node start = head;
        Node end = head;

        while (end.next != null) {
            end = end.next;
        }

        while (start.data < end.data) {
            if (start.data + end.data == k) {
                list.add(new int[] { start.data, end.data });
                start = start.next;
                end = end.prev;
            } else if (start.data + end.data < k) {
                start = start.next;
            } else {
                end = end.prev;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int k = 5;
        Node head = Node.constructDLL(new int[] { 1, 2, 3, 4, 9 });
        List<int[]> res = findPairs(head, k);
        for (int i = 0; i < res.size(); i++) {
            System.out.print("(" + res.get(i)[0] + ", " + res.get(i)[1] + ")  ");
        }
        // (1, 4) (2, 3)
    }
}