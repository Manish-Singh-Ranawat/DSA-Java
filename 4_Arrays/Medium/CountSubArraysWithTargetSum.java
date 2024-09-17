// Subarray Sum Equals K - https://leetcode.com/problems/subarray-sum-equals-k/description/

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [1,2,3], k = 3
// Output: 2

import java.util.HashMap;

public class CountSubArraysWithTargetSum {

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int k = 3;
        System.out.println(subarraySum(nums, k));
        // 2
    }
}
