// Single Number III - https://leetcode.com/problems/single-number-iii/

// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.

public class SingleNumber_III {
    public static int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        int bitMask = (xor & (xor - 1)) ^ xor;
        int bucketZero = 0;
        int bucketOne = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & bitMask) == 0) {
                bucketZero ^= nums[i];
            } else {
                bucketOne ^= nums[i];
            }
        }
        return new int[] { bucketZero, bucketOne };
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 3, 2, 5 };
        int res[] = singleNumber(nums);
        System.out.println(res[0] + " " + res[1]);
        // 5 3
    }
}
