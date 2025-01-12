// Symmetric Tree - https://leetcode.com/problems/symmetric-tree/description/

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Input: root = [1,2,2,3,4,4,3]
//         1
//       /   \
//     2       2
//   /  \    /   \
//  3    4  4     3 
// Output: true

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
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return root == null || checkSymmetric(root.left, root.right);
    }

    public static boolean checkSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == rightNode;
        }
        return (leftNode.val == rightNode.val) && checkSymmetric(leftNode.left, rightNode.right)
                && checkSymmetric(leftNode.right, rightNode.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 2, 2, 3, 4, 4, 3 });
        System.out.println(isSymmetric(root));
        // true
    }
}
