// Does array represent Heap - https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1?

// Given an array arr of size n, the task is to check if the given array can be a level order representation of a Max Heap.

// Input : n = 6, arr[] = {90, 15, 10, 7, 12, 2}
// Output: true
// Explanation: The given array represents below tree
//        90
//      /    \
//    15      10
//   /  \     /
// 7    12  2
// The tree follows max-heap property as every node is greater than all of its descendants.

public class DoesArrayRepresentHeap {
    public static boolean countSub(long arr[], long n) {
        for (int i = 0; i < n / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[left] > arr[i])
                return false;
            if (right < n && arr[right] > arr[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long arr[] = { 90, 15, 10, 7, 12, 2 };
        long n = arr.length;
        System.out.println(countSub(arr, n));
        // true
    }
}
