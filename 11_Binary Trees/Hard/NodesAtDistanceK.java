// All Nodes Distance K in Binary Tree - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

// You can return the answer in any order.

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//         3
//       /   \
//      5     1
//    /  \   /  \
//   6    2  0   8
//       / \
//      7   4
// Output: [7,4,1]
// Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

import java.util.ArrayList;
import java.util.HashMap;
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

// --------------------
public class NodesAtDistanceK {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        visited.put(target, true);
        queue.offer(target);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == k) {
                break;
            }
            dist++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);

                }
                if (parentMap.containsKey(node) && !visited.containsKey(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                    visited.put(parentMap.get(node), true);
                }
            }
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }

    public static void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        int k = 2;
        TreeNode root = TreeNode.createTree(
                new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        TreeNode target = root.left;
        System.out.println(distanceK(root, target, k));
        // [7, 4, 1]
    }

}
