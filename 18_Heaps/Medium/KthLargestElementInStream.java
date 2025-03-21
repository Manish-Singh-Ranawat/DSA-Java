// Kth Largest Element in a Stream - https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

// You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.

// You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.

// Implement the KthLargest class:
// - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
// - int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.

// Input:
// ["KthLargest", "add", "add", "add", "add", "add"]
// [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

// Output: [null, 4, 5, 5, 8, 8]

// Explanation:
// KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
// kthLargest.add(3); // return 4
// kthLargest.add(5); // return 5
// kthLargest.add(10); // return 5
// kthLargest.add(9); // return 8
// kthLargest.add(4); // return 8

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k)
            pq.poll();
        return pq.peek();
    }
}

public class KthLargestElementInStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3)); // 4
        System.out.println(kthLargest.add(5)); // 5
        System.out.println(kthLargest.add(10)); // 5
        System.out.println(kthLargest.add(9)); // 8
        System.out.println(kthLargest.add(4)); // 8
    }
}
