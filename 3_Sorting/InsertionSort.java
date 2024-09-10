// Insertion Sort - https://www.naukri.com/code360/problems/insertion-sort_3155179

public class InsertionSort {
    public static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        int n = arr.length;
        insertionSort(arr, n);
        printArray(arr);
        // 1 1 2 3 3 4 5 6 7 8 
    }
}
