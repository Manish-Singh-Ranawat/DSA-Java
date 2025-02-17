// Ninja’s Training - https://www.naukri.com/code360/problems/ninja-s-training_3621003?leftPanelTabValue=PROBLEM

// Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

// You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

// Input : n = 3, points = [[1, 2, 5], [3, 1, 1],[3, 3, 3]]
// Output : 11

// Explanation :
// One of the answers can be:
// On the first day, Ninja will learn new moves and earn 5 merit points. 
// On the second day, Ninja will do running and earn 3 merit points. 
// On the third day, Ninja will do fighting and earn 3 merit points. 
// The total merit point is 11 which is the maximum. 
// Hence, the answer is 11.

import java.util.Arrays;

public class NinjaTraining {
    // -- Tabulation with Space Optimization --
    public static int ninjaTraining(int n, int points[][]) {
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + dp[task]);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    }

    // -- Memoization --
    // public static int ninjaTraining(int n, int points[][]) {
    //     int[][] dp = new int[n][4];
    //     for (int i = 0; i < n; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }
    //     return helper(n - 1, 3, points, dp);
    // }

    // private static int helper(int day, int last, int[][] points, int[][] dp) {
    //     if (day == 0) {
    //         int max = 0;
    //         for (int task = 0; task < 3; task++) {
    //             if (task != last) {
    //                 max = Math.max(max, points[0][task]);
    //             }
    //         }
    //         return max;
    //     }
    //     if (dp[day][last] != -1)
    //         return dp[day][last];
    //     int max = 0;
    //     for (int task = 0; task < 3; task++) {
    //         if (task != last) {
    //             int point = points[day][task] + helper(day - 1, task, points, dp);
    //             max = Math.max(max, point);
    //         }
    //     }
    //     return dp[day][last] = max;
    // }

    public static void main(String[] args) {
        int n = 3;
        int[][] points = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
        System.out.println(ninjaTraining(n, points));
        // 11
    }
}