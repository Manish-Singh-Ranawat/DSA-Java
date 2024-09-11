// Quick Sort - https://www.naukri.com/code360/problems/quick-sort_983625

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    public static List<Integer> quickSort(List<Integer> arr) {
        quickSortHelper(arr, 0, arr.size() - 1);
        return arr;
    }

    public static void quickSortHelper(List<Integer> arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pIdx = partition(arr, low, high);
        quickSortHelper(arr, low, pIdx - 1);
        quickSortHelper(arr, pIdx + 1, high);
    }

    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        i++;
        Collections.swap(arr, i, high);
        return i;
    }

    public static void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.err.print(arr.get(i) + " ");
        }
        System.err.println();
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(6, 3, 9, 5, 2, 8));
        quickSort(arr);
        printArray(arr);
        // 2 3 5 6 8 9 
    }
}
