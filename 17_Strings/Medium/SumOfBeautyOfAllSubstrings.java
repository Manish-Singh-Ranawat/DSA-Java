// Sum of Beauty of All Substrings - https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of "abaacc" is 3 - 1 = 2.

// Given a string s, return the sum of beauty of all of its substrings.

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

public class SumOfBeautyOfAllSubstrings {
    public static int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
        // 5
    }
}
