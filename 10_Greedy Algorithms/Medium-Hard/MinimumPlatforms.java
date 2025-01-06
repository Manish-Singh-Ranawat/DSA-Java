// Minimum Number of Platforms - https://www.naukri.com/code360/problems/minimum-number-of-platforms_799400

// You have been given two arrays, 'AT' and 'DT', representing the arrival and departure times of all trains that reach a railway station.

// Your task is to find the minimum number of platforms required for the railway station so that no train needs to wait.

// Note :
// 1. Every train will depart on the same day and the departure time will always be greater than the arrival time. For example, A train with arrival time 2240 and departure time 1930 is not possible.

// 2. Time will be given in 24H format and colons will be omitted for convenience. For example, 9:05AM will be given as "905", or 9:10PM will be given as "2110".

// 3. Also, there will be no leading zeroes in the given times. For example, 12:10AM will be given as “10” and not as “0010”.

// Input: N=6, 
// at[] = {900, 945, 955, 1100, 1500, 1800} 
// dt[] = {920, 1200, 1130, 1150, 1900, 2000}
// Output:3
// Explanation: There are at-most three trains at a time. The train at 1100 arrived but the trains which had arrived at 945 and 955 have still not departed. So, we need at least three platforms here.

import java.util.Arrays;

public class MinimumPlatforms {
    public static int calculateMinPlatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        int required = 0;
        while (i < n && j < n) {
            if (at[i] <= dt[j]) {
                required++;
                i++;
            } else {
                required--;
                j++;
            }
            result = Math.max(result, required);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] at = { 900, 945, 955, 1100, 1500, 1800 };
        int[] dt = { 920, 1200, 1130, 1150, 1900, 2000 };
        System.out.println(calculateMinPlatforms(at, dt, n));
        // 3
    }
}
