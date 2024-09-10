// Selection Sort - https://www.naukri.com/code360/problems/selection-sort_981162

public class SelectionSort {
    public static void selectionSort(int arr[],int n) {
        for (int i = 0; i < n - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
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
        selectionSort(arr,n);
        printArray(arr);
        // 1 1 2 3 3 4 5 6 7 8 
    }
}
