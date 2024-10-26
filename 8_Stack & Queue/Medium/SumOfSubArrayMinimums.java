// Sum of Subarray Minimums - https://leetcode.com/problems/sum-of-subarray-minimums/description/

// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

// Input : arr = [3,1,2,4]
// Output : 17
// Explanation : Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.

import java.util.Stack;

public class SumOfSubArrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;
        int[] ns = nextSmaller(arr, n);
        int[] pse = previousSmallerOrEqual(arr, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = ns[i] - i;
            long contribution = (long) left * right % mod;
            contribution = contribution * arr[i] % mod;
            sum = (sum + contribution) % mod;
        }
        return (int) sum;
    }

    public static int[] nextSmaller(int[] arr, int n) {
        int ns[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            ns[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ns;
    }

    public static int[] previousSmallerOrEqual(int[] arr, int n) {
        int pse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
        // 17
    }
}
