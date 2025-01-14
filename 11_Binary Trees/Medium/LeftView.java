// Left View Of Binary Tree - https://www.naukri.com/code360/problems/left-view-of-binary-tree_625707

// You have been given a Binary Tree of 'n' nodes, where the nodes have integer values

// Print the left view of the binary tree.

// Input : [2, 35, 10, 2, 3, 5, 2]
//         2
//       /   \
//     35     10
//   /  \    /  \
//  2    3  5    2

// Output : [2, 35, 2]

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

public class LeftView {
    public static void printLeftView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getLeftView(root, 0, list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void getLeftView(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.data);
        }
        getLeftView(root.left, level + 1, list);
        getLeftView(root.right, level + 1, list);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 2, 35, 10, 2, 3, 5, 2 });
        printLeftView(root);
        // 2 35 2
    }
}
