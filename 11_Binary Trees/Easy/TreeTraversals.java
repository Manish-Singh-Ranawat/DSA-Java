// Tree Traversals - https://www.naukri.com/code360/problems/tree-traversal_981269

// You have been given a Binary Tree of 'N' nodes, where the nodes have integer values.

// Your task is to return the In-Order, Pre-Order, and Post-Order traversals of the given binary tree.

// Input: root = [1, 3, 4, 5, 2, 7, 6]
// Output: [ [5, 3, 2, 1, 7, 4, 6], [1, 3, 5, 2, 4, 7, 6], [5, 2, 3, 7, 6, 4, 1]]
// Explanation : 
//        1
//      /   \
//    3      4
//  /  \   /  \
// 5   2  7    6 
// The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
// The Preorder traversal will be [1, 3, 5, 2, 4, 7, 6].
// The Postorder traversal will be [5, 2, 3, 7, 6, 4, 1].

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class TreeTraversals {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> traversals = new ArrayList<>();
        if (root == null) {
            return traversals;
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 1));
        while (!s.isEmpty()) {
            Pair cur = s.pop();
            if (cur.num == 1) {
                pre.add(cur.node.data);
                cur.num = 2;
                s.push(cur);
                if (cur.node.left != null) {
                    s.push(new Pair(cur.node.left, 1));
                }
            } else if (cur.num == 2) {
                in.add(cur.node.data);
                cur.num = 3;
                s.push(cur);
                if (cur.node.right != null) {
                    s.push(new Pair(cur.node.right, 1));
                }
            } else {
                post.add(cur.node.data);
            }
        }
        traversals.add(in);
        traversals.add(pre);
        traversals.add(post);
        return traversals;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[] { 1, 3, 4, 5, 2, 7, 6 });
        System.out.println(getTreeTraversal(root));
        // [[5, 3, 2, 1, 7, 4, 6], [1, 3, 5, 2, 4, 7, 6], [5, 2, 3, 7, 6, 4, 1]]
    }
}
