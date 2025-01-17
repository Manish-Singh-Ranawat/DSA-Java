// Serialize and Deserialize Binary Tree - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

// Serialization is the process of converting a val structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

// Input: root = [1,2,3,null,null,4,5]
//         1
//       /   \
//      2     3
//          /   \
//         4     5
// Output: [1,2,3,null,null,4,5]

import java.util.ArrayList;
import java.util.Collections;
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
                if (current == null) {
                    list.add(null);
                } else {
                    list.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            levelOrder.add(list);
        }
        return levelOrder;
    }
}
// --------------------

public class SerialIzeAndDeserialize {
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder val = new StringBuilder("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                val.append("n ");
            } else {
                val.append(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return val.toString();
    }

    public static TreeNode deserialize(String val) {
        if (val == "")
            return null;
        String[] values = val.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        int n = values.length;
        while (i < n) {
            TreeNode node = queue.poll();
            if (i < n && !values[i].equals("n")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;
            if (i < n && !values[i].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 2, 3, null, null, 4, 5 });
        root = deserialize(serialize(root));
        System.out.println(TreeNode.levelOrder(root));
        // [[1], [2, 3], [null, null, 4, 5], [null, null, null, null]]
    }
}
