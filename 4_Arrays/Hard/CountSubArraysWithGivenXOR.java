// Subarrays with xor ‘K’ - https://www.naukri.com/code360/problems/subarrays-with-xor-k_6826258

// Given an array ‘A’ consisting of ‘N’ integers and an integer ‘B’, find the number of subarrays of array ‘A’ whose bitwise xor( ⊕ ) of all elements is equal to ‘B’.

// Input: A = [4, 2, 2, 6, 4] , b = 6
// Output: 4
// Explanation: The subarrays having xor of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

import java.util.HashMap;

public class CountSubArraysWithGivenXOR {

    public static int subarraysWithSumK(int[] a, int b) {
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            xor ^= a[i];
            count += map.getOrDefault(xor ^ b, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = { 4, 2, 2, 6, 4 };
        int b = 6;
        System.out.println(subarraysWithSumK(a, b));
        // 4
    }
}
