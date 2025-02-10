// Subsets II - https://leetcode.com/problems/subsets-ii/

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Input: nums = [1, 2, 2]
// Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]] 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private static void findSubsets(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            findSubsets(i + 1, nums, list, ans);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));
        // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
}
