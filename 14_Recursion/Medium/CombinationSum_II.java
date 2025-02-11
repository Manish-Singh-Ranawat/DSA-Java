// Combination Sum II - https://leetcode.com/problems/combination-sum-ii/description/

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: [[1,1,6], [1,2,5], [1,7], [2,6]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private static void findCombinations(int idx, int[] candidates, int target, List<Integer> list,
            List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                return;
            list.add(candidates[i]);
            findCombinations(i + 1, candidates, target - candidates[i], list, ans);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
        // [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }
}
