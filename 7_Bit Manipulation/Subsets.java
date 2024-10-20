// Subsets - https://leetcode.com/problems/subsets/description/

// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subSet = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int bitMask = 1 << j;
                if ((i & bitMask) != 0) {
                    subSet.add(nums[j]);
                }
            }
            powerSet.add(subSet);
        }
        return powerSet;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(subsets(nums));
        // [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }
}
