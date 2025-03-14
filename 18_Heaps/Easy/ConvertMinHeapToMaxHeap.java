// Convert Min-Heap to Max-Heap - https://www.naukri.com/code360/problems/convert-min-heap-to-max-heap_630293?leftPanelTabValue=PROBLEM

// You are given an array/list (arr) representing a min-heap. Your task is to write a function that converts the min-heap to a max-heap.

// Note : Change in the input array/list itself. You don't need to return or print the elements.

// Input : arr = [1, 2, 3, 4, 5, 6, 7]
// Output : [7, 5, 6, 4, 2, 1, 3]
// Explanation : For a min-heap, there can be multiple max heap. So the output can be any one of the following: [7, 5, 6, 4, 2, 1, 3], [7, 5, 6, 4, 3, 1, 2], [7, 6, 5, 4, 3, 1, 2], [7, 6, 5, 4, 2, 1, 3].

import java.util.Arrays;

public class ConvertMinHeapToMaxHeap {
    public static void minHeapToMaxHeap(long[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            downHeap(i, arr);
        }
    }

    private static void downHeap(int idx, long[] heap) {
        int size = heap.length;
        while (true) {
            int maxIdx = idx;
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            if (left < size && heap[left] > heap[maxIdx]) {
                maxIdx = left;
            }
            if (right < size && heap[right] > heap[maxIdx]) {
                maxIdx = right;
            }
            if (maxIdx == idx) {
                break;
            }
            swap(idx, maxIdx, heap);
            idx = maxIdx;
        }
    }

    private static void swap(int i, int j, long[] heap) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        minHeapToMaxHeap(arr);
        System.out.println(Arrays.toString(arr));
        // [7, 5, 6, 4, 2, 1, 3]
    }
}

