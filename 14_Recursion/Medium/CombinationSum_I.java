// Combination Sum - https://leetcode.com/problems/combination-sum/description/

// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_I {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private static void findCombinations(int i, int[] candidates, int target, List<Integer> list,
            List<List<Integer>> ans) {
        if (i >= candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (target >= candidates[i]) {
            list.add(candidates[i]);
            findCombinations(i, candidates, target - candidates[i], list, ans);
            list.removeLast();
        }
        findCombinations(i + 1, candidates, target, list, ans);
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));
        // [[2, 2, 3], [7]]
    }
}
