// Kth Smallest Element in a BST - https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

// Input: root = [3,1,4,null,2], k = 1
//         3
//       /   \
//      1     4
//       \     
//        2     
// Output: 1

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//  Definition for a binary search tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static TreeNode createTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}
// --------------------

public class KthSmallestElement {

    public static int kthSmallest(TreeNode root, int k) {
        int[] res = { 0 };
        int[] count = { 0 };
        inorder(root, k, count, res);
        return res[0];
    }

    public static void inorder(TreeNode root, int k, int[] count, int[] res) {
        if (root == null || count[0] >= k) {
            return;
        }
        inorder(root.left, k, count, res);
        count[0]++;
        if (k == count[0]) {
            res[0] = root.val;
            return;
        }
        inorder(root.right, k, count, res);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 3, 1, 4, null, 2 });
        int k = 1;
        System.out.println(kthSmallest(root, k));
        // 1
    }
}
