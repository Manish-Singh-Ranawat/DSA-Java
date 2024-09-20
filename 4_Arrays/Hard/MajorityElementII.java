// Majority Element II - https://leetcode.com/problems/majority-element-ii/

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Input: nums = [3,2,3]
// Output: [3]

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2++;
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element1) {
                count1++;
            }
            if (nums[i] == element2) {
                count2++;
            }
        }
        int min = (n / 3) + 1;
        if (count1 >= min) {
            ans.add(element1);
        }
        if (count2 >= min) {
            ans.add(element2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
        // [3]
    }
}
