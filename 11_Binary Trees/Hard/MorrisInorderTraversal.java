// Binary Tree Inorder Traversal - https://leetcode.com/problems/binary-tree-inorder-traversal/description/

// Given the root of a binary tree, return the inorder traversal of its nodes' values.

// Note: Write an algorithm that performs this traversal using constant space (O(1) auxiliary space complexity).

// Input: root = [1,null,2,3]
// Output: [1,3,2]
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

public class MorrisInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, null, 2, 3 });
        System.out.println(inorderTraversal(root));
        // [1, 3, 2]
    }
}
