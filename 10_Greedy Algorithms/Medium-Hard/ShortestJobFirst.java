// Shortest Job first - https://www.geeksforgeeks.org/problems/shortest-job-first/1

// Geek is a software engineer. He is assigned with the task of calculating average waiting time of all the processes by following shortest job first policy.

// The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.

// Given an array of integers bt of size n. Array bt denotes the burst time of each process. Calculate the average waiting time of all the processes and return the nearest integer which is smaller or equal to the output.

// Note: Consider all process are available at time 0.

// Input: n = 5 ,bt = [4,3,7,1,2]
// Output: 4
// Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.

import java.util.Arrays;

public class ShortestJobFirst {
    public static int solve(int bt[]) {
        Arrays.sort(bt);
        int n = bt.length;
        int time = 0;
        int waitTime = 0;
        for (int i = 0; i < n; i++) {
            waitTime += time;
            time += bt[i];
        }
        return waitTime / n;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] bt = { 4, 3, 7, 1, 2 };
        System.out.println(solve(bt));
        // 4
    }
}
