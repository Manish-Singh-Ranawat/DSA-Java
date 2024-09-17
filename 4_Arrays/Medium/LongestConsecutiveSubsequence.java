// Longest Consecutive Sequence - https://leetcode.com/problems/longest-consecutive-sequence/description/

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int longest = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int next = num + 1;
                int count = 1;
                while (set.contains(next)) {
                    next++;
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int nums[] = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
        // 4
    }
}
