// Insert Interval - https://leetcode.com/problems/insert-interval/description/

// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

import java.util.ArrayList;

public class InsertIntervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> inserted = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            inserted.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        inserted.add(newInterval);
        while (i < n) {
            inserted.add(intervals[i]);
            i++;
        }
        return inserted.toArray(new int[inserted.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        int[][] res = insert(intervals, newInterval);
        for (int i = 0; i < res.length; i++) {
            System.out.print("("+res[i][0] + "," + res[i][1] + ") ");
        }
        // (1,2) (3,10) (12,16) 
    }
}
