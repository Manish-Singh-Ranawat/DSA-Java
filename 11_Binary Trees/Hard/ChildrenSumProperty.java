// Children Sum Property - https://www.naukri.com/code360/problems/childrensumproperty_790723

// Given a binary tree of nodes 'N', you need to modify the value of its nodes, such that the tree holds the Children sum property.

// A binary tree is said to follow the children sum property if, for every node of that tree, the value of that node is equal to the sum of the value(s) of all of its children nodes( left child and the right child).

// Note :
//  1. You can only increment the value of the nodes, in other words, the modified value must be at least equal to the original value of that node.
//  2. You can not change the structure of the original binary tree.
//  3. A binary tree is a tree in which each node has at most two children.      
//  4. You can assume the value can be 0 for a NULL node and there can also be an empty tree.

// Input : [2, 35, 10, 2, 3, 5, 2]
//         2
//       /   \
//     35     10
//    /  \   /  \
//   2    3  5   2
// Output : Valid ( One of the possible answers is : 90, 70, 20, 35, 35, 10, 10, thus if the user modifies the given tree like this, the output printed will be valid).

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    list.add(current.data);
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    list.add(null);
                }
            }
            levelOrder.add(list);
        }
        levelOrder.removeLast();
        return levelOrder;
    }
}

// --------------------
public class ChildrenSumProperty {
    public static void changeTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int childSum = 0;
        if (root.left != null) {
            childSum += root.left.data;
        }
        if (root.right != null) {
            childSum += root.right.data;
        }
        if (childSum >= root.data) {
            root.data = childSum;
        } else {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }
        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        if (root.left != null)
            total += root.left.data;
        if (root.right != null)
            total += root.right.data;
        if (root.left != null || root.right != null) {
            root.data = total;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 2, 35, 10, 2, 3, 5, 2 });
        changeTree(root);
        System.out.println(TreeNode.levelOrder(root));
        // [[90], [70, 20], [35, 35, 10, 10]]
    }
}
