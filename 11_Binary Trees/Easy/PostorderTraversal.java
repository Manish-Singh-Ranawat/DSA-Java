// Binary Tree Postorder Traversal - https://leetcode.com/problems/binary-tree-postorder-traversal/description/

// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Input: root = [1,null,2,3]
// Output: [3,2,1]
// Explanation : 
//  1
//   \
//    2
//   /
// 3

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
// --------------------


public class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        traversePostorder(root, postorder);
        return postorder;
    }

    public static void traversePostorder(TreeNode root, List<Integer> postorder) {
        if (root == null) {
            return;
        }
        traversePostorder(root.left, postorder);
        traversePostorder(root.right, postorder);
        postorder.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, null, 2, 3 });
        System.out.println(postorderTraversal(root));
        // [3, 2, 1]
    }
}
