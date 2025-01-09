// Inorder Traversal - https://www.naukri.com/code360/problems/inorder-traversal_3839605

// You have been given a Binary Tree of 'n' nodes, where the nodes have integer values. Your task is to return the In-Order traversal of the given binary tree without using recursion.

// Input: root = [1, 3, 4, 5, 2, 7, 6]
// Output:  [5, 3, 2, 1, 7, 4, 6].
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

public class IterativeInorderTraversal {
    public static List<Integer> getInOrderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;
                node = stack.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 3, 4, 5, 2, 7, 6 });
        System.out.println(getInOrderTraversal(root));
        // [5, 3, 2, 1, 7, 4, 6]
    }
}
