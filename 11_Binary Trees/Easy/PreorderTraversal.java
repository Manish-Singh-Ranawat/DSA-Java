// Binary Tree Preorder Traversal - https://leetcode.com/problems/binary-tree-preorder-traversal/description/

// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Input: root = [1,null,2,3]
// Output: [1,2,3]
// Explanation : 
//  1
//   \
//    2
//   /
// 3

//  Definition for a binary tree node.

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
// -----------------

public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        traversePreorder(root, preorder);
        return preorder;
    }

    public static void traversePreorder(TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }
        preorder.add(root.val);
        traversePreorder(root.left, preorder);
        traversePreorder(root.right, preorder);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, null, 2, 3 });
        System.out.println(preorderTraversal(root));
        // [1, 2, 3]
    }
}
