// Next Greater Element I - https://leetcode.com/problems/next-greater-element-i/description/

// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n2 = nums2.length;
        for (int i = n2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int n1 = nums1.length;
        int[] nge = new int[n1];
        for (int i = 0; i < n1; i++) {
            nge[i] = map.get(nums1[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] nge = nextGreaterElement(nums1, nums2);
        int n = nge.length;
        for (int i = 0; i < n; i++) {
            System.out.print(nge[i] + " ");
        }
        // -1 3 -1
    }
}
