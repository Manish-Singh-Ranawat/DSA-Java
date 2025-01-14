// Top View Of Binary Tree - https://www.naukri.com/code360/problems/top-view-of-the-tree_799401

// You are given a Binary Tree of 'n' nodes.
// The Top view of the binary tree is the set of nodes visible when we see the tree from the top.

// Find the top view of the given binary tree, from left to right.

// Input : [1, 2, 3, 4, 5, null, 6, null, 7, null, null, 8]
//         1
//       /   \
//     2      3
//   /  \      \
//  4    5      6
//   \         /
//    7      8

// Output : [4, 2, 1, 3, 6]
// Explanation : From left to right, the top view of the tree will be [4, 2, 1, 3, 6], where 7, 5 and 8 will be hidden when we see from the top of the tree.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
class Pair {
    TreeNode node;
    int x;

    Pair(TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }
}

public class TopView {
    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> topView = new ArrayList<>();
        if (root == null) {
            return topView;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                TreeNode node = cur.node;
                int x = cur.x;
                if (!map.containsKey(x)) {
                    map.put(x, node.data);
                }
                if (node.left != null) {
                    queue.offer(new Pair(node.left, x - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, x + 1));
                }
            }
        }
        for (int val : map.values()) {
            topView.add(val);
        }
        return topView;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 1, 2, 3, 4, 5, null, 6, null, 7, null, null, 8 });
        System.out.println(getTopView(root));
        // [4, 2, 1, 3, 6]
    }
}
