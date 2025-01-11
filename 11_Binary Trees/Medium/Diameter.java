// Diameter of Binary Tree - https://leetcode.com/problems/diameter-of-binary-tree/description/

// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

// Input: root = [1,2,3,4,5]
//       1
//     /  \
//    2    3
//   / \
//  4   5 
// Output: 3

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

public class Diameter {

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] d = { 0 };
        height(root, d);
        return d[0];
    }

    public static int height(TreeNode root, int[] d) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left, d);
        int rh = height(root.right, d);
        d[0] = Math.max(d[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 2, 3, 4, 5 });
        System.out.println(diameterOfBinaryTree(root));
        // 3
    }
}
