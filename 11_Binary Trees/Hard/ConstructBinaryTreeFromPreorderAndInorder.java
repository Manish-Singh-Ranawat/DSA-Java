// Construct Binary Tree from Preorder and Inorder Traversal - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
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

public class ConstructBinaryTreeFromPreorderAndInorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int pLen = preorder.length;
        int iLen = inorder.length;
        for (int i = 0; i < iLen; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = createTree(preorder, 0, pLen - 1, inorder, 0, iLen - 1, inMap);
        return root;
    }

    public static TreeNode createTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;
        root.left = createTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = createTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(TreeNode.levelOrder(root));
        // [[3], [9, 20], [null, null, 15, 7]]
    }
}
