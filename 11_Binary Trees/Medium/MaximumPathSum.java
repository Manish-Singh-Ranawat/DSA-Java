// Binary Tree Maximum Path Sum - https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

// The path pathSum of a path is the pathSum of the node's values in the path.

// Given the root of a binary tree, return the maximum path pathSum of any non-empty path.

// Input: root = [-10,9,20,null,null,15,7]
//       -10
//      /   \
//    9      20
//          /  \
//         15   7 
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path pathSum of 15 + 20 + 7 = 42.

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

public class MaximumPathSum {
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = { 0 };
        pathSum(root, maxSum);
        return maxSum[0];
    }

    public static int pathSum(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int lSum = Math.max(0, pathSum(root.left, maxSum));
        int rSum = Math.max(0, pathSum(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], lSum + rSum + root.val);
        return root.val + Math.max(lSum, rSum);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { -10, 9, 20, null, null, 15, 7 });
        System.out.println(maxPathSum(root));
        // 42
    }
}
