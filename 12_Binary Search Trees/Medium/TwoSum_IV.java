// Two Sum IV - Input is a BST - https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

// Input: root = [5,3,6,2,4,null,7], k = 9
//         5
//       /   \
//      3     6
//    /  \     \
//   2    4     7
// Output: true

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//  Definition for a binary search tree node.
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

class BstIterator {
    Stack<TreeNode> s;
    boolean reverse = false;

    public BstIterator(TreeNode root, boolean reverse) {
        this.s = new Stack<>();
        this.reverse = reverse;
        pushAll(root, s);
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public int next() {
        TreeNode node = s.pop();
        if (reverse) {
            pushAll(node.left, s);
        } else {
            pushAll(node.right, s);
        }
        return node.val;
    }

    public void pushAll(TreeNode root, Stack<TreeNode> s) {
        while (root != null) {
            s.push(root);
            if (reverse) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}

public class TwoSum_IV {
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        BstIterator l = new BstIterator(root, false);
        BstIterator r = new BstIterator(root, true);
        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 5, 3, 6, 2, 4, null, 7 });
        int k = 9;
        System.out.println(findTarget(root, k));
        // true
    }
}
