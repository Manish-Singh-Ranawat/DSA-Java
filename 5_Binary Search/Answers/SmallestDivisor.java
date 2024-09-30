// Find the Smallest Divisor Given a Threshold - https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

public class SmallestDivisor {

    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, nums[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (threshold >= sumOfDivisions(nums, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int sumOfDivisions(int[] nums, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double) nums[i] / divisor);
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 5, 9 };
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
        // 5
    }
}
