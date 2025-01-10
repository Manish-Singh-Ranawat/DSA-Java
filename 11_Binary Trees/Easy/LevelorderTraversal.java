// Binary Tree Level Order Traversal - https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

// Input: root = [3,9,20,null,null,15,7]
//        3
//      /   \
//    9      20
//          /  \
//        15    7 
// Output: [[3],[9,20],[15,7]]

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

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode cur = q.poll();
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}
// --------------------

public class LevelorderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            levelOrder.add(list);
        }
        return levelOrder;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        System.out.println(levelOrder(root));
        // [[3], [9, 20], [15, 7]]
    }
}
