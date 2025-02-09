// Subsets - https://leetcode.com/problems/subsets/

// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

import java.util.ArrayList;
import java.util.List;

public class Subsets_I {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> powerSet = new ArrayList<>();
        generateSubsets(0, nums, n, new ArrayList<>(), powerSet);
        return powerSet;
    }

    private static void generateSubsets(int i, int nums[], int n, ArrayList<Integer> subset,
            List<List<Integer>> powerSet) {
        if (i >= n) {
            powerSet.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        generateSubsets(i + 1, nums, n, subset, powerSet);
        subset.removeLast();
        generateSubsets(i + 1, nums, n, subset, powerSet);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(subsets(nums));
        // [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
    }
}
