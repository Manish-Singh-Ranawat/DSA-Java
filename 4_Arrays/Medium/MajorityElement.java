// Majority Element - https://leetcode.com/problems/majority-element/description/

// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

public class MajorityElement {
    // Moore’s Voting Algorithm
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
        // 2
    }
}
