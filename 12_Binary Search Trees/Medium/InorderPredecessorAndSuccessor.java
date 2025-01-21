// Predecessor And Successor In BST - https://www.naukri.com/code360/problems/_893049?leftPanelTabValue=PROBLEM

// You have been given a binary search tree of integers with ‘N’ nodes. You are also given 'KEY' which represents data of a node of this tree.

// Your task is to return the predecessor and successor of the given node in the BST.

// Note:
// 1. The predecessor of a node in BST is that node that will be visited just before the given node in the inorder traversal of the tree. If the given node is visited first in the inorder traversal, then its predecessor is NULL.
// 2. The successor of a node in BST is that node that will be visited immediately after the given node in the inorder traversal of the tree. If the given node is visited last in the inorder traversal, then its successor is NULL.
// 3. The node for which the predecessor and successor will not always be present. If not present, you can hypothetically assume it's position (Given that it is a BST) and accordingly find out the predecessor and successor.
// 4. A binary search tree (BST) is a binary tree data structure which has the following properties.
//      • The left subtree of a node contains only nodes with data less than the node’s data.
//      • The right subtree of a node contains only nodes with data greater than the node’s data.
//      • Both the left and right subtrees must also be binary search trees.

// Input : root = [15, 10, 20, 8, 12, 16, 25] , key = 10
//         15
//       /    \
//     10     20
//   /  \     /  \
//  8   12   16  25
// Output : [8, 12]
// Explanation : The inorder traversal of this tree will be 8 10 12 15 16 20 25.
// Since the node with data 8 is on the immediate left of the node with data 10 in the inorder traversal, the node with data 8 is the predecessor.
// Since the node with data 12 is on the immediate right of the node with data 10 in the inorder traversal, the node with data 12 is the successor.

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

public class InorderPredecessorAndSuccessor {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        TreeNode predecessor = inorderPredecessor(root, key);
        list.add(predecessor == null ? -1 : predecessor.data);
        TreeNode successor = inorderSuccessor(root, key);
        list.add(successor == null ? -1 : successor.data);
        return list;
    }

    public static TreeNode inorderSuccessor(TreeNode root, int key) {
        TreeNode successor = null;
        while (root != null) {
            if (root.data <= key) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static TreeNode inorderPredecessor(TreeNode root, int key) {
        TreeNode predecessor = null;
        while (root != null) {
            if (root.data >= key) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 15, 10, 20, 8, 12, 16, 25 });
        int key = 10;
        System.out.println(predecessorSuccessor(root, key));
        // [8, 12]
    }
}