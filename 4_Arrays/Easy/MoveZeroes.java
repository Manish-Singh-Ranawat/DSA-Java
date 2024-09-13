
//  Move Zeroes - https://leetcode.com/problems/move-zeroes/description/

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

public class MoveZeroes {
    public static void moveZeroes(int nums[]) {
        int n = nums.length;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return;
        }
        for (int i = idx + 1; i < n; i++) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                nums[i] = 0;
                idx++;
            }
        }
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        printArray(nums);
        // 1 3 12 0 0 
    }
}