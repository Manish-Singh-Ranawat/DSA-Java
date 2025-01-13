// Boundary Traversal of Binary Tree - https://www.naukri.com/code360/problems/boundary-traversal_790725

// You are given a binary tree having 'n' nodes.

// The boundary nodes of a binary tree include the nodes from the left and right boundaries and the leaf nodes, each node considered once.

// Figure out the boundary nodes of this binary tree in an Anti-Clockwise direction starting from the root node.

// Input : [10, 5, 20, 3, 8, 18, 25, null, null, 7, null, null, null, null, null, null, null]
//         10
//       /   \
//     5      20
//   /  \    /  \
//  3   8   18   25
//     /
//    7

// Output : [10, 5, 3, 7, 18, 25, 20]
// Explanation :
// The nodes on the left boundary are [10, 5, 3]
// The nodes on the right boundary are [10, 20, 25]
// The leaf nodes are [3, 7, 18, 25].

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// import java.util.Stack;

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

public class BoundaryTraversal {
    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) {
            return boundary;
        }
        if (!isLeaf(root)) {
            boundary.add(root.data);
        }
        addLeftBoundary(root, boundary);
        addLeafNodes(root, boundary);
        addRightBoundary(root, boundary);
        return boundary;
    }

    public static boolean isLeaf(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    public static void addLeftBoundary(TreeNode root, List<Integer> boundary) {
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node)) {
                boundary.add(node.data);
            }
            node = node.left != null ? node.left : node.right;
        }
    }

    public static void addRightBoundary(TreeNode root, List<Integer> boundary) {
        TreeNode node = root.right;
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                temp.add(node.data);
            }
            node = node.right != null ? node.right : node.left;
        }
        Collections.reverse(temp);
        boundary.addAll(temp);
    }

    public static void addLeafNodes(TreeNode root, List<Integer> boundary) {
        if (isLeaf(root)) {
            boundary.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeafNodes(root.left, boundary);
        }
        if (root.right != null) {
            addLeafNodes(root.right, boundary);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 10, 5, 20, 3, 8, 18, 25, null, null, 7, null, null, null, null, null, null, null });
        System.out.println(traverseBoundary(root));
        // [10, 5, 3, 7, 18, 25, 20]
    }
}
