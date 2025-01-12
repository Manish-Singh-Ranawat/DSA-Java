// Binary Tree Paths - https://leetcode.com/problems/binary-tree-paths/description/

// Given the root of a binary tree, return all root-to-leaf paths in any order.

// A leaf is a node with no children.

// Input: root = [1,2,3,null,5]
//       1
//     /  \
//    2    3
//     \
//      5 
// Output:  ["1->2->5","1->3"]

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

public class RootToLeafNodePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        getPaths(root, paths, "");
        return paths;
    }

    public static void getPaths(TreeNode root, List<String> paths, String s) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            paths.add(s + root.val);
            return;
        }
        s = s + root.val + "->";
        getPaths(root.left, paths, s);
        getPaths(root.right, paths, s);
    }

    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 2, 3, null, 5 });
        System.out.println(binaryTreePaths(root));
        // [1->2->5, 1->3]
    }

}
