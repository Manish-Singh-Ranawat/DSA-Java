// Kth Largest Element in an Array - https://leetcode.com/problems/kth-largest-element-in-an-array/description/

// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?

// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(findKthLargest(nums, k));
        // 5
    }
}
