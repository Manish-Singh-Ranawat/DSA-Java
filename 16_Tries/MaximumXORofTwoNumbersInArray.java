// Maximum XOR of Two Numbers in an Array - https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/

// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

// Input: nums = [3,10,5,25,2,8]
// Output: 28
// Explanation: The maximum result is 5 XOR 25 = 28.

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

public class MaximumXORofTwoNumbersInArray {
    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums)
            trie.insert(num);
        int maxi = 0;
        for (int num : nums) {
            maxi = Math.max(maxi, trie.getMax(num));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 10, 5, 25, 2, 8 };
        System.out.println(findMaximumXOR(nums));
        // 28
    }
}
