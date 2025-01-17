// Construct Binary Tree from Inorder and Postorder Traversal - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//         3
//       /   \
//      9     20
//           /  \
//         15    7
// Output: [3,9,20,null,null,15,7]

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    list.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    list.add(null);
                }
            }
            levelOrder.add(list);
        }
        levelOrder.removeLast();
        return levelOrder;
    }
}
// --------------------

public class ConstructBinaryTreeFromPostorderAndInorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int pLen = postorder.length;
        int iLen = inorder.length;
        for (int i = 0; i < iLen; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = createTree(postorder, 0, pLen - 1, inorder, 0, iLen - 1, inMap);
        return root;
    }

    public static TreeNode createTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart,
            int inEnd,
            HashMap<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;
        root.left = createTree(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, inMap);
        root.right = createTree(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(TreeNode.levelOrder(root));
        // [[3], [9, 20], [null, null, 15, 7]]
    }
}
