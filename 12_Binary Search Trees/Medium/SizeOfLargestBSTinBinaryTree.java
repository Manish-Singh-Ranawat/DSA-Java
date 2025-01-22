// Size of Largest BST in Binary Tree - https://www.naukri.com/code360/problems/largest-bst-subtree_893103?leftPanelTabValue=PROBLEM

// You have been given a Binary Tree of 'N' nodes, where the nodes have integer values. Your task is to return the size of the largest subtree of the binary tree which is also a BST.

// A binary search tree (BST) is a binary tree data structure which has the following properties.
// • The left subtree of a node contains only nodes with data less than the node’s data.
// • The right subtree of a node contains only nodes with data greater than the node’s data.
// • Both the left and right subtrees must also be binary search trees.

// Input : root = [2, 1, 3] 
//         2
//       /   \
//      1     3
// Output : 3
// Explanation : In the given binary tree, subtree rooted at 2 is a BST and its size is 3.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  Definition for a binary search tree node.
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

class NodeValue {
    int size;
    int minVal;
    int maxVal;

    NodeValue(int size, int minVal, int maxVal) {
        this.size = size;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }
}

public class SizeOfLargestBSTinBinaryTree {
    public static int largestBST(TreeNode root) {
        return helper(root).size;
    }

    public static NodeValue helper(TreeNode root) {
        if (root == null) {
            return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        if (root.data > left.maxVal && root.data < right.minVal) {
            return new NodeValue(left.size + right.size + 1, Math.min(root.data, left.minVal),
                    Math.max(root.data, right.maxVal));
        }
        return new NodeValue(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 2, 1, 3 });
        System.out.println(largestBST(root));
        // 3
    }
}