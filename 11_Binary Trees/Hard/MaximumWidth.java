// Maximum Width of Binary Tree - https://leetcode.com/problems/maximum-width-of-binary-tree/description/

// Given the root of a binary tree, return the maximum width of the given tree.

// The maximum width of a tree is the maximum width among all levels.

// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

// It is guaranteed that the answer will in the range of a 32-bit signed integer.

// Input: root = [1,3,2,5,3,null,9]
//        1
//      /   \
//     3     2
//   /  \     \
//  5    3     9
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

import java.util.LinkedList;
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
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class MaximumWidth {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int width = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().num;
            int l = 0;
            int r = 0;
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                TreeNode node = cur.node;
                int num = cur.num;
                if (i == 0) {
                    l = num;
                }
                if (i == size - 1) {
                    r = num;
                }
                if (node.left != null) {
                    queue.add(new Pair(node.left, (2 * num - min) + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, (2 * num - min) + 2));
                }

            }
            width = Math.max(width, r - l + 1);
        }
        return width;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 3, 2, 5, 3, null, 9 });
        System.out.println(widthOfBinaryTree(root));
        // 4
    }
}
