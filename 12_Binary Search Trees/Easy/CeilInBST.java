// Ceil from BST - https://www.naukri.com/code360/problems/ceil-from-bst_920464

// Ninja is given a binary search tree and an integer. Now he is given a particular key in the tree and returns its ceil value. Can you help Ninja solve the problem?

// Note: Ceil of an integer is the closest integer greater than or equal to a given number.

// Input: root = [8, 5, 10, 2, 6] , x = 4
//         8
//       /   \
//      5      10
//    /  \    
//   2    6     
// Output: 5
// Explanation : The smallest value node of the BST which is greater than or equal to 4 is 5.

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

public class CeilInBST {
    public static int findCeil(TreeNode root, int x) {
        int ceil = -1;
        while (root != null) {
            if (root.data == x) {
                ceil = root.data;
                return ceil;
            } else if (root.data > x) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 8, 5, 10, 2, 6 });
        int x = 4;
        System.out.println(findCeil(root, x));
        // 6
    }
}