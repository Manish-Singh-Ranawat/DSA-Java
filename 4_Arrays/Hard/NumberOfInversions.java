// Number of Inversions - https://www.naukri.com/code360/problems/number-of-inversions_6840276

// There is an integer array ‘A’ of size ‘N’.
// Number of inversions in an array can be defined as the number of pairs of ‘i’, ‘j’ such that ‘i’ < ‘j’ and ‘A[i]’ > ‘A[j]’.
// You must return the number of inversions in the array.

// Input: A = [5, 3, 2, 1, 4], N = 5
// Output: 7
// Explanation: The pairs satisfying the condition for inversion are (1, 2), (1, 3), (1, 4), (1, 5), (2, 3), (2, 4), and (3, 4). 
// The number of inversions in the array is 7.

public class NumberOfInversions {

    public static int numberOfInversions(int[] a, int n) {
        return mergeSort(a, 0, n-1);
    }

    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public static int merge(int arr[], int low, int mid, int high) {
        int count = 0;
        int i = low;
        int j = mid + 1;
        int temp[] = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                count += mid - i + 1;
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        k=0;
        for (int idx = low; idx <= high; idx++) {
            arr[idx] = temp[k++];
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = { 5, 3, 2, 1, 4 };
        int n = a.length;
        System.out.println(numberOfInversions(a, n));
        // 7
    }
}
