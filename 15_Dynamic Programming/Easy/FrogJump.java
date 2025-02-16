// Frog Jump - https://www.naukri.com/code360/problems/frog-jump_3621012?leftPanelTabValue=PROBLEM

// There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

// Input : n = 4, heights = [10, 20, 30, 10]
// Output : 20

// Explanation :
// The frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost).
// Then a jump from the 2nd stair to the last stair (|10-20| = 10 energy lost).
// So, the total energy lost is 20 which is the minimum. 
// Hence, the answer is 20.

import java.util.Arrays;

public class FrogJump {
    // -- Tabulation with Space Optimization --
    public static int frogJump(int n, int heights[]) {
        int prev2 = 0;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(heights[i] - heights[i - 1]);
            int ss = (i > 1) ? prev2 + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;
            int cur = Math.min(fs, ss);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    // -- Memoization --
    // public static int frogJump(int n, int heights[]) {
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return helper(n - 1, heights, dp);
    // }

    // private static int helper(int i, int[] heights, int[] dp) {
    //     if (i == 0)
    //         return 0;
    //     if (dp[i] != -1)
    //         return dp[i];
    //     int left = helper(i - 1, heights, dp) + Math.abs(heights[i] - heights[i - 1]);
    //     int right = Integer.MAX_VALUE;
    //     if (i > 1)
    //         right = helper(i - 2, heights, dp) + Math.abs(heights[i] - heights[i - 2]);
    //     return dp[i] = Math.min(left, right);
    // }

    public static void main(String[] args) {
        int n = 4;
        int[] heights = { 10, 20, 30, 10 };
        System.out.println(frogJump(n, heights));
        // 20
    }
}
