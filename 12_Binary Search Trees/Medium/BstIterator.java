// Binary Search Tree Iterator - https://leetcode.com/problems/binary-search-tree-iterator/

// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

//- BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
// - boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
// - int next() Moves the pointer to the right, then returns the number at the pointer.

// Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

// You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

// Input :
// ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
// [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
//         7
//       /   \
//      3     15
//           /  \
//          9   20
// Output : [null, 3, 7, true, 9, true, 15, true, 20, false]

// Explanation :
// BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
// bSTIterator.next();    // return 3
// bSTIterator.next();    // return 7
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 9
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 15
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 20
// bSTIterator.hasNext(); // return False

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
                    list.add(current.val);
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

public class BstIterator {
    Stack<TreeNode> s;

    public BstIterator(TreeNode root) {
        this.s = new Stack<>();
        pushLefts(root, s);
    }

    public int next() {
        TreeNode node = s.pop();
        pushLefts(node.right, s);
        return node.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public void pushLefts(TreeNode root, Stack<TreeNode> s) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(
                new Integer[] { 7, 3, 15, null, null, 9, 20 });
        BstIterator bstIterator = new BstIterator(root);
        System.out.println(bstIterator.next()); // 3
        System.out.println(bstIterator.next()); // 7
        System.out.println(bstIterator.hasNext()); // true
        System.out.println(bstIterator.next()); // 9
        System.out.println(bstIterator.hasNext()); // true
        System.out.println(bstIterator.next()); // 15
        System.out.println(bstIterator.hasNext()); // true
        System.out.println(bstIterator.next()); // 20
        System.out.println(bstIterator.hasNext()); // false
    }
}
