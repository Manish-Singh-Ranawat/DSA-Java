// Balanced Binary Tree - https://leetcode.com/problems/balanced-binary-tree/description/

// Given a binary tree, determine if it is height-balanced.

// Input: root = [3,9,20,null,null,15,7]
//        3
//      /   \
//    9      20
//          /  \
//         15   7 
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

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        if (lh == -1)
            return -1;
        int rh = height(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        System.out.println(isBalanced(root));
        // true
    }
}
