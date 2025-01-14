// Bottom View Of Binary Tree - https://www.naukri.com/code360/problems/bottom-view-of-binary-tree_893110?

// You are given a 'Binary Tree'.
// Return the bottom view of the binary tree.

// Note :
// 1. A node will be in the bottom-view if it is the bottom-most node at its horizontal distance from the root. 
// 2. The horizontal distance of the root from itself is 0. The horizontal distance of the right child of the root node is 1 and the horizontal distance of the left child of the root node is -1. 
// 3. The horizontal distance of node 'n' from root = horizontal distance of its parent from root + 1, if node 'n' is the right child of its parent.
// 4. The horizontal distance of node 'n' from root = horizontal distance of its parent from the root - 1, if node 'n' is the left child of its parent.
// 5. If more than one node is at the same horizontal distance and is the bottom-most node for that horizontal distance, including the one which is more towards the right.

// Input : [1, 2, 3, 4, 5, null, 6, null, 7, null, null, 8]
//         1
//       /   \
//     2      3
//   /  \      \
//  4    5      6
//   \         /
//    7      8

// Output : [4, 7, 5, 8, 6]
// Explanation : From left to right, the bottom view of the tree will be [4, 7, 5, 8, 6], where 2, 1 and 3 will be hidden when we see from the bottom of the tree.

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

public class BottomView {
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> bottomView = new ArrayList<>();
        if (root == null) {
            return bottomView;
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
                map.put(x, node.data);
                if (node.left != null) {
                    queue.offer(new Pair(node.left, x - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, x + 1));
                }
            }
        }
        for (int val : map.values()) {
            bottomView.add(val);
        }
        return bottomView;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 1, 2, 3, 4, 5, null, 6, null, 7, null, null, 8 });
        System.out.println(bottomView(root));
        // [4, 7, 5, 8, 6]
    }
}
