// Merge Intervals - https://leetcode.com/problems/merge-intervals/description/

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || intervals[i][0] > ans.getLast()[1]) {
                ans.add(intervals[i]);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i][0] + "," + arr[i][1] + "] ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int result[][] = merge(intervals);
        print(result);
        // [1,6] [8,10] [15,18]
    }
}
