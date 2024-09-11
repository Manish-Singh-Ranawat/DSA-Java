// MergeSort - https://www.naukri.com/code360/problems/merge-sort_920442

public class MergeSort {

    public static void mergeSort(int[] arr, int n) {
        mergeSortHelper(arr, 0, n - 1);
    }

    public static void mergeSortHelper(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortHelper(arr, low, mid);
        mergeSortHelper(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int temp[] = new int[high + 1 - low];
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int idx = low; idx <= high; idx++) {
            arr[idx] = temp[k++];
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i] + " ");
        }
        System.err.println();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        int n = arr.length;
        mergeSort(arr, n);
        printArray(arr);
        // 2 3 5 6 8 9 
    }
}
