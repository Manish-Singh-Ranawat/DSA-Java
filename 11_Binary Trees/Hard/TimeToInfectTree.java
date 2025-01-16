// Amount of Time for Binary Tree to Be Infected - https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

// You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

// Each minute, a node becomes infected if:

// The node is currently uninfected.
// The node is adjacent to an infected node.
// Return the number of minutes needed for the entire tree to be infected.

// Input: root = [1,5,3,null,4,10,6,9,2], start = 3
//         1
//       /   \
//      5     3
//      \    /  \
//       4  10   6
//      / \
//     9   2
// Output: 4
// Explanation: The following nodes are infected during:
// - Minute 0: Node 3
// - Minute 1: Nodes 1, 10 and 6
// - Minute 2: Node 5
// - Minute 3: Node 4
// - Minute 4: Nodes 9 and 2
// It takes 4 minutes for the whole tree to be infected so we return 4.

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
public class TimeToInfectTree {

    public static int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = markParents(root, parentMap, start);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        visited.put(startNode, true);
        queue.offer(startNode);
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                    flag = true;
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                    flag = true;
                }
                if (parentMap.containsKey(node) && !visited.containsKey(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                    visited.put(parentMap.get(node), true);
                    flag = true;
                }
            }
            if (flag) {
                minutes++;
            }
        }
        return minutes;
    }

    public static TreeNode markParents(TreeNode root, HashMap<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode startNode = new TreeNode(-1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == start) {
                startNode = node;
            }
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return startNode;
    }

    public static void main(String[] args) {
        int start = 3;
        TreeNode root = TreeNode.createTree(
                new Integer[] { 1, 5, 3, null, 4, 10, 6, 9, 2 });
        TreeNode target = root.left;
        System.out.println(amountOfTime(root, start));
        // 4
    }
}
