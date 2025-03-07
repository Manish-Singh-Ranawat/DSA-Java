// Maximum XOR With an Element From Array - https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/

// You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].

// The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.

// Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.

// Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
// Output: [3,3,7]
// Explanation:
// 1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
// 2) 1 XOR 2 = 3.
// 3) 5 XOR 2 = 7.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Node {
    Node[] links;

    Node() {
        this.links = new Node[2];
    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public void put(int bit, Node node) {
        links[bit] = node;
    }

    public Node get(int bit) {
        return links[bit];
    }
}

class Trie {
    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                ans = ans | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return ans;
    }
}

public class MaximumXORWithElementFromArray {
    public static int[] maximizeXor(int[] nums, int[][] queries) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = queries.length;
        for (int i = 0; i < n; i++) {
            list.add(new int[] { queries[i][1], queries[i][0], i });
        }
        Arrays.sort(nums);
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        Trie trie = new Trie();
        int idx = 0;
        for (int[] q : list) {
            while (idx < nums.length && nums[idx] <= q[0]) {
                trie.insert(nums[idx]);
                idx++;
            }
            ans[q[2]] = idx == 0 ? -1 : trie.getMax(q[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4 };
        int[][] queries = { { 3, 1 }, { 1, 3 }, { 5, 6 } };
        System.out.println(Arrays.toString(maximizeXor(nums, queries)));
        // [3,3,7]
    }
}
