// Binary Subarrays With Sum - https://leetcode.com/problems/binary-subarrays-with-sum/description/

// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
// A subarray is a contiguous part of the array.

// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]

public class BinarySubArraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int totalSubArrays = countSubarraysWithSumAtMost(nums, goal)
                - countSubarraysWithSumAtMost(nums, goal - 1);
        return totalSubArrays;
    }

    public static int countSubarraysWithSumAtMost(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int n = nums.length;
        int sum = 0;
        int subArraysCount = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > goal && l <= r) {
                sum -= nums[l];
                l++;
            }
            if (sum <= goal) {
                subArraysCount += r - l + 1;
            }
            r++;
        }
        return subArraysCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
        // 4
    }
}
