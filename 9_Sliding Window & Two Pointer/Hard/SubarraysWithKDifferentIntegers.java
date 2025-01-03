// Subarrays with K Different Integers - https://leetcode.com/problems/subarrays-with-k-different-integers/description/

// Given an integer array nums and an integer k, return the number of good subarrays of nums.

// A good array is an array where the number of different integers in that array is exactly k.
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int totalSubArrays = countSubarraysWithAtMostKDistinct(nums, k)
                - countSubarraysWithAtMostKDistinct(nums, k - 1);
        return totalSubArrays;
    }

    public static int countSubarraysWithAtMostKDistinct(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int r = 0;
        int subArraysCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                if (map.get(nums[l]) == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], map.get(nums[l]) - 1);
                }
                l++;
            }
            if (map.size() <= k) {
                subArraysCount += r - l + 1;
            }
            r++;
        }
        return subArraysCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
        // 7
    }
}
