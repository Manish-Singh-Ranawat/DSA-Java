// Minimum Multiplications to reach End - https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

// Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

// Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

// Input: arr[] = {2, 5, 7}, start = 3, end = 30
// Output: 2
// Explanation:
// Step 1: 3*2 = 6 % 100000 = 6 
// Step 2: 6*5 = 30 % 100000 = 30

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end)
            return 0;
        int n = arr.length;
        int mod = 100000;
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        dist[start] = 0;
        q.offer(new int[] { start, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int steps = cur[1];
            for (int i = 0; i < n; i++) {
                int num = (arr[i] * node) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if (num == end)
                        return steps + 1;
                    q.offer(new int[] { num, steps + 1 });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7 };
        int start = 3;
        int end = 30;
        System.out.println(minimumMultiplications(arr, start, end));
        // 2
    }
}
