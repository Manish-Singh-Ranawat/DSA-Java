// Minimum element in BST - https://www.naukri.com/code360/problems/minimum-element-in-bst_8160462

// You are given a Binary Search Tree.
// Find the minimum value in it.

// Note: All the values in the given binary search tree are unique.

// Input : root = [6, 4, 7, 2, 5]
// Output: 2
// Explanation: For the given input BST is:
//       6
//      / \
//    4    7
//   / \
//  2   5

import java.util.LinkedList;
import java.util.Queue;

//  Definition for a binary search tree node.
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
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

public class MinimumElementInBST {
    public static int minValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 6, 4, 7, 2, 5 });
        System.out.println(minValue(root));
        // 2
    }
}
