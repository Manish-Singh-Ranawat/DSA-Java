// Search in a Binary Search Tree - https://leetcode.com/problems/search-in-a-binary-search-tree/description/

// You are given the root of a binary search tree (BST) and an integer val.

// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

// Input: root = [4,2,7,1,3], val = 2
//         4
//       /   \
//      2     7
//    /  \    / 
//   1    3     
// Output: [2,1,3]

import java.util.LinkedList;
import java.util.Queue;

//  Definition for a binary search tree node.
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

public class SearchInBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val > root.val ? root.right : root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 4, 2, 7, 1, 3 });
        int val = 2;
        TreeNode node = searchBST(root, val);
        System.out.println(node.val);
        // 2
    }
}
