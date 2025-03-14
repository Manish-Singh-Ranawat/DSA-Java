// Rank Transform of an Array - https://leetcode.com/problems/rank-transform-of-an-array/description/

// Given an array of integers arr, replace each element with its rank.

// The rank represents how large the element is. The rank has the following rules:
// - Rank is an integer starting from 1.
// - The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
// - Rank should be as small as possible.

// Input: arr = [37,12,28,9,100,56,80,5,12]
// Output: [5,3,4,2,8,6,7,1,3]

import java.util.Arrays;
import java.util.PriorityQueue;

public class RankTransformOfArray {
    public static int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { arr[i], i });
        }
        int[] ans = new int[n];
        int rank = 0;
        int prev = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0];
            int idx = cur[1];
            if (val != prev)
                rank++;
            ans[idx] = rank;
            prev = val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 37, 12, 28, 9, 100, 56, 80, 5, 12 };
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
        // [5, 3, 4, 2, 8, 6, 7, 1, 3]
    }
}
