// Path In A Tree - https://www.naukri.com/code360/problems/path-in-a-tree_3843990

// You are given a binary tree with ‘N’ number of nodes and a node ‘X’. Your task is to print the path from the root node to the given node ‘X’.

// A binary tree is a hierarchical data structure in which each node has at most two children.

// Input : root = [1, 2, 3, 4, 5, 6, 7] , x = 7
//         1
//       /   \
//     2      3
//   /  \    /  \
//  4    5  6    7

// Output : [1, 3, 7]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class RootToNodePath {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> path = new ArrayList<>();
        getPath(root, x, path);
        return path;
    }

    public static boolean getPath(TreeNode root, int x, ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.data);
        if (root.data == x) {
            return true;
        }
        if (getPath(root.left, x, path) || getPath(root.right, x, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int x = 7;
        TreeNode root = TreeNode.createTree(
                new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        System.out.println(pathInATree(root, x));
        // [1, 3, 7]
    }

}
