
// Missing Number - https://leetcode.com/problems/missing-number/description/

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int XOR1 = 0;
        int XOR2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            XOR1 = XOR1 ^ i;
            XOR2 = XOR2 ^ nums[i];
        }
        XOR1 = XOR1 ^ n;
        return XOR1 ^ XOR2;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 0, 1 };
        System.out.println(missingNumber(nums));
        // 2
    }
}
