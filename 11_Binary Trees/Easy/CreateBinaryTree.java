// Create Binary Tree - https://www.naukri.com/code360/problems/create-binary-tree_8360671

// Given an array 'arr' that contains 7 integers representing the values of nodes in a binary tree. This represents level order. The first element of the array represents the value of the root node.

// Your objective is to construct a binary tree using the remaining 6 elements of the array, creating nodes for each of these values and return root node.

// Input: arr = [ 1, 2, 3, 4, 5, 6, 7]
// Output: 1
// Explanation: The 7 node binary tree is represented below.
//        1
//      /   \
//    2      3
//  /  \   /  \
// 4   5  6    7 

// Following is the class structure of the Node class:
class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class CreateBinaryTree {
    public static Node createTree(int[] arr) {
        int n = arr.length;
        if (n <= 0) {
            return null;
        }
        return buildTree(arr, 0, n);
    }

    public static Node buildTree(int[] arr, int i, int n) {
        if (i >= n) {
            return null;
        }
        Node root = new Node(arr[i]);
        root.left = buildTree(arr, 2 * i + 1, n);
        root.right = buildTree(arr, 2 * i + 2, n);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = createTree(arr);
        System.out.println(root.data);
        // 1
    }
}
