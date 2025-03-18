// Task Scheduler - https://leetcode.com/problems/task-scheduler/description/

// You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

// Return the minimum number of CPU intervals required to complete all tasks.

// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 8
// Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
// After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.offer(freq[i]);
        }
        int time = 0;
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            int taskCount = 0;
            List<Integer> list = new ArrayList<>();
            while (cycle > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur - 1 > 0) {
                    list.add(cur - 1);
                }
                taskCount++;
                cycle--;
            }
            for (int it : list)
                pq.offer(it);
            time += pq.isEmpty() ? taskCount : n + 1;
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(tasks, n));
        // 8
    }
}
