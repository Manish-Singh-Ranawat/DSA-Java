// Flatten Binary Tree to Linked List - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

// Input: root = [1,2,5,3,4,null,6]
//         1
//       /   \
//      2     5
//    /  \     \  
//   3    4     6   
// Output: [1,null,2,null,3,null,4,null,5,null,6]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    list.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    list.add(null);
                }
            }
            levelOrder.add(list);
        }
        levelOrder.removeLast();
        return levelOrder;
    }
}
// --------------------

public class FlattenBinaryTreeToLinkedList {
    public static void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode prev = cur.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    // using stack
    public static void flattenUsingStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (!stack.isEmpty()) {
                node.right = stack.peek();
            }
            node.left = null;
        }
    }

    // using recursion
    TreeNode prev = null;

    public void flattenUsingRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 2, 5, 3, 4, null, 6 });
        flatten(root);
        System.out.println(TreeNode.levelOrder(root));
        // [[1], [null, 2], [null, 3], [null, 4], [null, 5], [null, 6]]
    }
}
