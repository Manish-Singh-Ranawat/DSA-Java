// Delete Node in a BST - https://leetcode.com/problems/delete-node-in-a-bst/

// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// Basically, the deletion can be divided into two stages:

// Search for a node to remove.
// If the node is found, delete the node.

// Input: root = [5,3,6,2,4,null,7], key = 3
//         5
//       /   \
//      3     6
//    /  \     \
//   2    4     7
// Output: [5,2,6,null,4,null,7]
//          5
//       /    \
//      2      6
//      \       \ 
//       4       7

// Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
// One valid answer is  [5,2,6,null,4,null,7] shown in the above BST.
// Please notice that another valid answer is [5,4,6,2,null,null,7] and it's also accepted.

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
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

public class DeleteNode {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = root.right;
        }
        return root.left;
    }

    public static TreeNode findLastRight(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 5,3,6,2,4,null,7 });
        int key = 3;
        root = deleteNode(root, key);
        System.out.println(TreeNode.levelOrder(root));
        // [[5], [2, 6], [null, 4, null, 7]]
    }
}
