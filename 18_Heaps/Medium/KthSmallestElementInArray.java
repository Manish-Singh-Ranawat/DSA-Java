// Kth Smallest - https://www.naukri.com/code360/problems/kth-smallest-element_893056

// Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array.

// Follow up: Don't solve it using the inbuilt sort function.

// Examples :

// Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
// Output:  7
// Explanation: 3rd smallest element in the given array is 7.

import java.util.PriorityQueue;

public class KthSmallestElementInArray {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;
        System.out.println(kthSmallest(arr, k));
        // 7
    }
}
