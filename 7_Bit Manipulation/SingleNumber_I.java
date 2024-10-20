// Single Number I - https://leetcode.com/problems/single-number/description/

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Input: nums = [2,2,1]
// Output: 1

public class SingleNumber_I {
    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int single = 0;
        for (int i = 0; i < n; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1 };
        System.out.println(singleNumber(nums));
        // 1
    }
}
