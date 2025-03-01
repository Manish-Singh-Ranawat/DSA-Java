// Longest Increasing Subsequence - https://www.naukri.com/code360/problems/longest-increasing-subsequence_630459?

// For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.

// Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.

// Input : arr = [5, 4, 11, 1, 16, 8]
// Output : 3
// Explanation : Length of longest subsequence is 3 i.e. [5, 11, 16] or [4, 11, 16].

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequenceUsingBinarySearch {
    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int idx = Collections.binarySearch(list, arr[i]);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                list.set(idx, arr[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 11, 1, 16, 8 };
        System.out.println(longestIncreasingSubsequence(arr));
        // 3
    }
}
