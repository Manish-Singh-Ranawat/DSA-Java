// Next Greater Element II - https://leetcode.com/problems/next-greater-element-ii/description/

// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.

import java.util.Stack;

public class NextGreaterElement_II {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int[] nge = nextGreaterElements(nums);
        int n = nge.length;
        for (int i = 0; i < n; i++) {
            System.out.print(nge[i] + " ");
        }
        // 2 -1 2
    }
}
