// Painter's Partition Problem - https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557

// Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘k’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.

// You are supposed to return the area of the minimum time to get this job done of painting all the ‘n’ boards under a constraint that any painter will only paint the continuous sections of boards.

// Input: arr = [2, 1, 5, 6, 2, 3], k = 2
// Output: 11
// Explanation: First painter can paint boards 1 to 3 in 8 units of time and the second painter can paint boards 4-6 in 11 units of time. Thus both painters will paint all the boards in max(8,11) = 11 units of time. It can be shown that all the boards can't be painted in less than 11 units of time.

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartition {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int n = boards.size();
        if (k > n)
            return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, boards.get(i));
            high += boards.get(i);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int painters = countPainters(boards, n, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countPainters(ArrayList<Integer> boards, int n, int time) {
        int count = 1;
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime += boards.get(i);
            if (maxTime > time) {
                count++;
                maxTime = boards.get(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        int k = 2;
        System.out.println(findLargestMinDistance(arr, k));
        // 11
    }
}
