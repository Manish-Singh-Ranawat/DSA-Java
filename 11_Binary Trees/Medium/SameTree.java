// Same Tree - https://leetcode.com/problems/same-tree/description/

// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

// Input: p = [1,2,3], q = [1,2,3]
//       1                   1
//     /  \                /  \
//    2    3              2    3
// Output: true

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  Definition for a binary tree node.
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
// ----------------

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = TreeNode.createTree(new Integer[] { 1, 2, 3 });
        TreeNode q = TreeNode.createTree(new Integer[] { 1, 2, 3 });
        System.out.println(isSameTree(p, q));
        // true
    }
}
