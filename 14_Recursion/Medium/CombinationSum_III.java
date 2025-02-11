// Combination Sum III - https://leetcode.com/problems/combination-sum-iii/description/

// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
// Only numbers 1 through 9 are used.
// Each number is used at most once.

// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private static void findCombinations(int start, int k, int n, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k) {
            if (n == 0)
                ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < 10; i++) {
            if (i <= n) {
                list.add(i);
                findCombinations(i + 1, k, n - i, list, ans);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(combinationSum3(k, n));
        // [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
    }
}
