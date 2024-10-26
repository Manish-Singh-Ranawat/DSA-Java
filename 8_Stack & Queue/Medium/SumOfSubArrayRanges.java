// Sum of Subarray Ranges - https://leetcode.com/problems/sum-of-subarray-ranges/description/

// You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

// Return the sum of all subarray ranges of nums.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [1,2,3]
// Output: 4
// Explanation: The 6 subarrays of nums are the following:
// [1], range = largest - smallest = 1 - 1 = 0 
// [2], range = 2 - 2 = 0
// [3], range = 3 - 3 = 0
// [1,2], range = 2 - 1 = 1
// [2,3], range = 3 - 2 = 1
// [1,2,3], range = 3 - 1 = 2
// So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.

import java.util.Stack;

public class SumOfSubArrayRanges {
    public static long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public static long sumSubarrayMaxs(int[] nums) {
        int n = nums.length;
        int[] ng = nextGreater(nums, n);
        int[] pge = previousGreaterOrEqual(nums, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = ng[i] - i;
            sum += left * right * nums[i];
        }
        return sum;
    }

    public static long sumSubarrayMins(int[] nums) {
        int n = nums.length;
        int[] ns = nextSmaller(nums, n);
        int[] pse = previousSmallerOrEqual(nums, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = ns[i] - i;
            sum += left * right * (long) nums[i];
        }
        return sum;
    }

    public static int[] nextGreater(int[] nums, int n) {
        int ng[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            ng[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ng;
    }

    public static int[] previousGreaterOrEqual(int[] nums, int n) {
        int pge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    public static int[] nextSmaller(int[] nums, int n) {
        int ns[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            ns[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ns;
    }

    public static int[] previousSmallerOrEqual(int[] nums, int n) {
        int pse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public static void main(String[] args) {
        int[] mums = { 1, 2, 3 };
        System.out.println(subArrayRanges(mums));
        // 4
    }
}
