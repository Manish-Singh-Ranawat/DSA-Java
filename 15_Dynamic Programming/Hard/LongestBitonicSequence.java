// Longest Bitonic Sequence - https://www.naukri.com/code360/problems/longest-bitonic-sequence_1062688?

// A Bitonic Sequence is a sequence of numbers that is first strictly increasing and then strictly decreasing.

// A strictly ascending order sequence is also considered bitonic, with the decreasing part as empty, and same for a strictly descending order sequence.

// You are given an array 'arr' consisting of 'n' positive integers.
// Find the length of the longest bitonic subsequence of 'arr'.

// Input : arr = [1, 2, 1, 2, 1]
// Output : 3
// Explanation : The longest bitonic subsequence for this array will be [1, 2, 1]. Please note that [1, 2, 2, 1] is not a valid bitonic subsequence, because the consecutive 2's are neither strictly increasing, nor strictly decreasing.

public class LongestBitonicSequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int idx = 0; idx < n; idx++) {
            dp1[idx] = 1;
            for (int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if (arr[idx] > arr[prevIdx]) {
                    dp1[idx] = Math.max(dp1[idx], 1 + dp1[prevIdx]);
                }
            }
        }
        int ans = 0;
        for (int idx = n - 1; idx >= 0; idx--) {
            dp2[idx] = 1;
            for (int prevIdx = n - 1; prevIdx > idx; prevIdx--) {
                if (arr[idx] > arr[prevIdx]) {
                    dp2[idx] = Math.max(dp2[idx], 1 + dp2[prevIdx]);
                }
            }
            ans = Math.max(ans, dp1[idx] + dp2[idx] - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 2, 1 };
        System.out.println(longestBitonicSequence(arr, arr.length));
        // 3
    }
}
