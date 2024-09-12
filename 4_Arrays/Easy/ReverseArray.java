// Reverse The Array - https://www.naukri.com/code360/problems/reverse-the-array_1262298?

// Given an array/list 'ARR' of integers and a position ‘M’. You have to reverse the array after that position.

// Example:
// We have an array ARR = {1, 2, 3, 4, 5, 6} and M = 3 , considering 0 
// based indexing so the subarray {5, 6} will be reversed and our 
// output array will be {1, 2, 3, 4, 6, 5}.

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collections;

public class ReverseArray {
    public static void reverseArray(ArrayList<Integer> arr, int m) {
        int left = m + 1;
        int right = arr.size() - 1;
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            // OR  Collections.swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.err.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int m = 3;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        reverseArray(arr, m);
        printArray(arr);
        // 1 2 3 4 6 5 
    }
}
