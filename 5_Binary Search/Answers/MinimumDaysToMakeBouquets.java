// Minimum Number of Days to Make m Bouquets - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   we can only make one bouquet.
// After day 2: [x, _, _, _, x]    we can only make two bouquets.
// After day 3: [x, _, x, _, x]    we can make 3 bouquets. The answer is 3.

public class MinimumDaysToMakeBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean possible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int noOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                noOfBouquets += (count / k);
                count = 0;
            }
        }
        noOfBouquets += (count / k);
        return noOfBouquets >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
        // 3
    }
}
