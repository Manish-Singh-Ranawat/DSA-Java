// Permutation Sequence - https://leetcode.com/problems/permutation-sequence/

// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"

// Given n and k, return the kth permutation sequence.

// Input: n = 3, k = 3
// Output: "213"

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder("");
        k = k - 1;
        while (true) {
            int idx = k / fact;
            ans.append(numbers.get(idx));
            numbers.remove(idx);
            if (numbers.size() == 0)
                break;
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n, k));
        // 213
    }
}
