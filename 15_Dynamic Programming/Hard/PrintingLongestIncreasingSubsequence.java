// Printing Longest Increasing Subsequence - https://www.naukri.com/code360/problems/printing-longest-increasing-subsequence_8360670?leftPanelTabValue=PROBLEM

// You are given an array 'arr' of length 'n'.
// Find the Longest Increasing Subsequence of the array.

// A subsequence is a subset of an array achieved by removing some (possibly 0) elements without changing the order of the remaining elements.
// Increasing subsequence means a subsequence in which all the elements are strictly increasing.

// Longest increasing subsequence is an increasing subsequence that has the largest length possible.

// Please note that there may be more than one LIS (Longest Increasing Subsequence) possible. Return any one of the valid sequences.

// Input: ‘arr’ = [5, 6, 3, 4, 7, 6]
// Output: [5, 6, 7] OR [3, 4, 7] OR [3, 4, 6]
// Explanation: All these three subsequences are valid Longest Increasing Subsequences. Returning any of them is correct.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintingLongestIncreasingSubsequence {
    public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxLen = 0;
        int lastIdx = 0;
        for (int idx = 0; idx < n; idx++) {
            dp[idx] = 1;
            hash[idx] = idx;
            for (int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if (arr[idx] > arr[prevIdx] && 1 + dp[prevIdx] > dp[idx]) {
                    dp[idx] = 1 + dp[prevIdx];
                    hash[idx] = prevIdx;
                }
            }
            if (dp[idx] > maxLen) {
                maxLen = dp[idx];
                lastIdx = idx;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIdx]);
        while (hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            ans.add(arr[lastIdx]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 3, 4, 7, 6 };
        int n = arr.length;
        System.out.println(printingLongestIncreasingSubsequence(arr, n));
        // [5, 6, 7]
    }
}
