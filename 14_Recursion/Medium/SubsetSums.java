// Subset Sums - https://www.naukri.com/code360/problems/subset-sum_3843086?leftPanelTabValue=PROBLEM

// You are given an array'nums'of‘n’integers.

// Return all subset sums of'nums'in a non-decreasing order.

// Note : Here subset sum means sum of all elements of a subset of'nums'.A subset of'nums'is an array formed by removing some(possibly zero or all)elements of'nums'.

// Input: nums = [1, 2]
// Output: [0, 1, 2, 3]
// Explanation: Following are the subset sums: 0(by considering empty subset), 1, 2, 1+2 = 3
// So,subset sum are [0, 1, 2, 3].

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    public static ArrayList<Integer> subsetSums(int num[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsetSums(0, 0, num, ans);
        Collections.sort(ans);
        return ans;
    }

    private static void findSubsetSums(int i, int sum, int[] num, ArrayList<Integer> ans) {
        if (i == num.length) {
            ans.add(sum);
            return;
        }
        findSubsetSums(i + 1, sum + num[i], num, ans);
        findSubsetSums(i + 1, sum, num, ans);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        System.out.println(subsetSums(nums));
        // [0, 1, 2, 3]
    }
}
