// Preorder Traversal - https://www.naukri.com/code360/problems/preorder-traversal_3838888

// You have been given a Binary Tree of 'N' nodes, where the nodes have integer values. Your task is to find the Pre-Order traversal of the given binary tree without using recursion.

// Input: root = [1, 3, 4, 5, 2, 7, 6]
// Output: [1, 3, 5, 2, 4, 7, 6]
// Explanation : 
//        1
//      /   \
//    3      4
//  /  \   /  \
// 5   2  7    6 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//  Definition for a binary tree node.
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

public class IterativePreorderTraversal {
    public static List<Integer> getPreOrderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            preorder.add(current.data);
            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                stack.add(current.left);
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 3, 4, 5, 2, 7, 6 });
        System.out.println(getPreOrderTraversal(root));
        // [1, 3, 5, 2, 4, 7, 6]
    }
}
