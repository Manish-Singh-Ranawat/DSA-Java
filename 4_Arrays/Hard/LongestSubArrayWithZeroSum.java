// Longest subarray with 0 sum - https://www.naukri.com/code360/problems/longest-subarray-with-zero-sum_6783450

// Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

// Input: arr[] = {15,-2,2,-8,1,7,10,23}
// Output: 5
// Explanation: The largest subarray with sum 0 is -2 2 -8 1 7.

import java.util.HashMap;

public class LongestSubArrayWithZeroSum {

    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(getLongestZeroSumSubarrayLength(arr));
        // 5
    }
}