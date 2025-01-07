// Non-overlapping Intervals - https://leetcode.com/problems/non-overlapping-intervals/description/

// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int lastEnd = intervals[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastEnd) {
                lastEnd = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(intervals));
        // 1
    }
}
