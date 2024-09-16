// Rearrange Array Elements by Sign - https://leetcode.com/problems/rearrange-array-elements-by-sign/

// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

// You should return the array of nums such that the the array follows the given conditions:
// 1. Every consecutive pair of integers have opposite signs.
// 2. For all integers with the same sign, the order in which they were present in nums is preserved.
// 3. The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

// Input: nums = [3,1,-2,-5,2,-4]
// Output: [3,-2,1,-5,2,-4]
// Explanation:
// The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
// The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
// Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  

public class RearrangeArrayBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int posIndex = 0;
        int negIndex = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, -2, -5, 2, -4 };
        nums = rearrangeArray(nums);
        print(nums);
        // 3 -2 1 -5 2 -4
    }
}
