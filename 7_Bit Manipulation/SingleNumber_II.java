// Single Number II - https://leetcode.com/problems/single-number-ii/description/

// Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Input: nums = [2,2,3,2]
// Output: 3

public class SingleNumber_II {

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int bucketOne = 0;
        int bucketTwo = 0;
        for (int i = 0; i < n; i++) {
            bucketOne = (bucketOne ^ nums[i]) & (~bucketTwo);
            bucketTwo = (bucketTwo ^ nums[i]) & (~bucketOne);
        }
        return bucketOne;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 3, 2 };
        System.out.println(singleNumber(nums));
        // 3
    }
}
