// Floor in BST - https://www.naukri.com/code360/problems/floor-from-bst_920457

// You are given a BST(Binary search tree)with’N’number of nodes and a value‘X’.Your task is to find the greatest value node of the BST which is smaller than or equal to‘X’.

// Note:'x'is not smaller than the smallest node of BST.

// Input: root = [10, 5, 15, 2, 6] , x = 7
//         10
//       /   \
//      5      15
//    /  \    
//   2    6     
// Output: 6
// Explanation : The greatest value node of the BST which is smaller than or equal to  7 is 6.

import java.util.LinkedList;
import java.util.Queue;

//  Definition for a binary search tree node.
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

public class FloorInBST {
    public static int floorInBST(TreeNode root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.data == x) {
                floor = root.data;
                return floor;
            } else if (root.data < x) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 10, 5, 15, 2, 6 });
        int x = 7;
        System.out.println(floorInBST(root, x));
        // 6
    }
}
