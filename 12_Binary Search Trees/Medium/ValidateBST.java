// Validate Binary Search Tree - https://leetcode.com/problems/validate-binary-search-tree/description/

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:
// - The left subtree of a node contains only nodes with keys less than the node's key.
// - The right subtree of a node contains only nodes with keys greater than the node's key.
// - Both the left and right subtrees must also be binary search trees.

// Input: root = [2,1,3]
//         1
//       /   \
//      1     3
// Output: true

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

public class ValidateBST {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) &&
                isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 2, 1, 3 });
        System.out.println(isValidBST(root));
        // true
    }
}
