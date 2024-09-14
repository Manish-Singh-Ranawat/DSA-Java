
// Single Number - https://leetcode.com/problems/single-number/description/

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Input: nums = [4,1,2,1,2]
// Output: 4

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int single = 0;
        for (int i = 0; i < n; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));
        // 4
    }
}
