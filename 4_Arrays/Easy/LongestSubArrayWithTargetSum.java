// Longest Sub-Array with Sum K - https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_5713505?

// Find the length of the longest subarray in which the sum of elements is equal to ‘K’.
// If there is no subarray whose sum is ‘K’ then you should return 0.

// Input: ‘N’ = 5,  ‘K’ = 4, ‘NUMS’ = [ 1, 2, 1, 0, 1 ]
// Output: 4
// There are two subarrays with sum = 4, [1, 2, 1] and [2, 1, 0, 1]. Hence the length of the longest subarray with sum = 4 is 4.

import java.util.HashMap;

public class LongestSubArrayWithTargetSum {

    public static int getLongestSubarray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 0, 1 };
        int k = 4;
        System.out.println(getLongestSubarray(nums, k));
        // 4
    }
}