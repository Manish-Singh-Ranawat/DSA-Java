// Permutations - https://leetcode.com/problems/permutations/description/

// Given an array nums of distinct integers, return all the possible 
// permutations. You can return the answer in any order.

// Input: nums = [1, 2, 3]
// Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(0, nums.length, nums, ans);
        return ans;
    }

    private static void findPermutations(int idx, int n, int[] nums, List<List<Integer>> ans) {
        if (idx == n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = idx; i < n; i++) {
            swap(i, idx, nums);
            findPermutations(idx + 1, n, nums, ans);
            swap(i, idx, nums);
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }
}
