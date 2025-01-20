// Insert into a Binary Search Tree - https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

// Input: root = [4,2,7,1,3], val = 5
//         4
//       /   \
//      2     7
//    /  \     
//   1    3     
// Output: [4,2,7,1,3,5]
//          4
//       /    \
//      2      7
//    /  \    / 
//   1    3  5  

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

public class InsertNode {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = root;
        if (temp == null) {
            temp = new TreeNode(val);
            return temp;
        }
        while (true) {
            if (val > temp.val) {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                }
                temp = temp.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 4, 2, 7, 1, 3 });
        int val = 5;
        root = insertIntoBST(root, val);
        System.out.println(TreeNode.levelOrder(root));
        // [[4], [2, 7], [1, 3, 5, null]]
    }
}
