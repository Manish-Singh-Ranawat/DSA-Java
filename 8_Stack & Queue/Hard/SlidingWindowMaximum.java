// Sliding Window Maximum - https://leetcode.com/problems/sliding-window-maximum/description/

// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        // 3 3 5 5 6 7
    }
}
