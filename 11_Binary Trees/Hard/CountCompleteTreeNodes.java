// Count Complete Tree Nodes - https://leetcode.com/problems/count-complete-tree-nodes/description/

// Given the root of a complete binary tree, return the number of the nodes in the tree.

// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Design an algorithm that runs in less than O(n) time complexity.

// Input: root = [1,2,3,4,5,6]
//         1
//       /   \
//      2     3
//    /  \    /  
//   4    5  6   
// Output: 6

import java.util.ArrayList;
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
}

// --------------------
public class CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);
        if (lh == rh) {
            return (1 << lh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int findLeftHeight(TreeNode root) {
        int lh = 0;
        while (root != null) {
            lh++;
            root = root.left;
        }
        return lh;
    }

    public static int findRightHeight(TreeNode root) {
        int rh = 0;
        while (root != null) {
            rh++;
            root = root.right;
        }
        return rh;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 1, 2, 3, 4, 5, 6 });
        System.out.println(countNodes(root));
        // 6
    }
}
