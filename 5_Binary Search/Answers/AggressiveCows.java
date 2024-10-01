// Aggressive Cows - https://www.naukri.com/code360/problems/aggressive-cows_1082559

// You are given an array 'arr' of size 'n' which denotes the position of stalls.
// You are also given an integer 'k' which denotes the number of aggressive cows.

// You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum canWePlace.
// Find the maximum canWePlace minimum distance.

// Input Format: k = 4, arr[] = {0,3,4,7,10,9}
// Output: 3
// Explanation: The maximum canWePlace minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

import java.util.Arrays;

public class AggressiveCows {

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlace(stalls, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canWePlace(int[] stalls, int k, int distance) {
        int n = stalls.length;
        int countCows = 1;
        int lastStall = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastStall >= distance) {
                countCows++;
                lastStall = stalls[i];
            }
            if (countCows >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int k = 4;
        int arr[] = { 0, 3, 4, 7, 10, 9 };
        System.out.println(aggressiveCows(arr, k));
        // 3
    }
}