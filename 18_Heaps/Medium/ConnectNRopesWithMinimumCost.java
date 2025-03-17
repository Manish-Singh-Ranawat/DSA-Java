// Connect N Ropes With Minimum Cost - https://www.naukri.com/code360/problems/connect-n-ropes-with-minimum-cost_630476?leftPanelTabValue=PROBLEM

// You have been given 'N' ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.

// The test-data is such that the result will fit into a 32-bit integer.

// Input : arr = [4, 3, 2, 6 ]
// Output : 29
// Explanation:
// 1) If we first connect ropes of lengths 2 and 3, we will left with three ropes of lengths 4, 6 and 5.
// 2) Now then, if we connect ropes of lengths 4 and 5, we will left with two ropes of lengths 6 and 9.
// 3) Finally, we connect the remaining two ropes and all ropes are now connected.

// Total cost for connecting all ropes in this way is 5 + 9 + 15 = 29  which is the optimized cost.

// Now there are other ways also for connecting ropes. For example, if we connect 4 and 6 first (we get three ropes of lengths 3, 2 and 10), then connect 10 and 3 (we get two ropes of length 13 and 2). Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38 which is not the optimal cost

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
    public static long connectRopes(int[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int it : arr)
            pq.offer((long) it);
        long sum = 0;
        while (pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll();
            sum += x + y;
            pq.offer(x + y);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 6 };
        System.out.println(connectRopes(arr));
        // 29
    }
}
