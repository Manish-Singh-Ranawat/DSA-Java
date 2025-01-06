// Job Sequencing Problem - https://www.naukri.com/code360/problems/job-sequencing-problem_1169460

// You are given a 'Nx3' 2-D array 'Jobs' describing 'N' jobs where 'Jobs[i][0]' denotes the id of 'i-th' job, 'Jobs[i][1]' denotes the deadline of 'i-th' job, and 'Jobs[i][2]' denotes the profit associated with 'i-th job'.

// You will make a particular profit if you complete the job within the deadline associated with it. Each job takes 1 unit of time to be completed, and you can schedule only one job at a particular time.

// Return the number of jobs to be done to get maximum profit.

// Note : If a particular job has a deadline 'x', it means that it needs to be completed at any time before 'x'.
// Assume that the start time is 0.

// Input: 'N' = 3, Jobs = [[1, 1, 30], [2, 3, 40], [3, 2, 10]].
// Output: [3, 80]
// Explanation: All the jobs have different deadlines. So we can complete all the jobs.
// At time 0-1, Job 1 will complete.
// At time 1-2, Job 3 will complete.
// At time 2-3, Job 2 will complete.
// So our answer is [3 80].

import java.util.Arrays;

public class JobSequencingProblem {
    public static int[] jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> (b[2] - a[2]));
        int n = jobs.length;
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }
        int days[] = new int[maxDeadline + 1];
        Arrays.fill(days, -1);
        int count = 0;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = jobs[i][1]; j > 0; j--) {
                if (days[j] == -1) {
                    days[j] = i;
                    profit += jobs[i][2];
                    count++;
                    break;
                }
            }
        }
        return new int[] { count, profit };
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] jobs = { { 1, 1, 30 }, { 2, 3, 40 }, { 3, 2, 10 } };
        int[] ans = jobScheduling(jobs);
        System.out.println(ans[0] + " " + ans[1]);
        // 3 80
    }
}
