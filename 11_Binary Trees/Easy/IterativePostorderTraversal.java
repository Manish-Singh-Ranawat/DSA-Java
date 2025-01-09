// Postorder Traversal 

// You have been given a Binary Tree of 'n' nodes, where the nodes have integer values. Your task is to return the Post-Order traversal of the given binary tree without using recursion.

// Input: root = [1, 3, 4, 5, 2, 7, 6]
// Output: [5, 2, 3, 7, 6, 4, 1].
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

public class IterativePostorderTraversal {
    public static List<Integer> getPostOrderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        while (!stack2.isEmpty()) {
            postorder.add(stack2.pop().data);
        }
        return postorder;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 3, 4, 5, 2, 7, 6 });
        System.err.println(getPostOrderTraversal(root));
        // [5, 2, 3, 7, 6, 4, 1]
    }
}
