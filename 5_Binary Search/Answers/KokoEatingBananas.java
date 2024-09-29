// Koko Eating Bananas - https://leetcode.com/problems/koko-eating-bananas/description/

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// Input: piles = [3,6,7,11], h = 8
// Output: 4

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (h >= countHours(piles, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countHours(int piles[], int mid) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double) piles[i] / mid);
        }
        return hours;
    }

    public static void main(String[] args) {
        int piles[] = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
        // 4
    }
}
