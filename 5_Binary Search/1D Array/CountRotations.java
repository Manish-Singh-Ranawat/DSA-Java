// Rotation - https://www.naukri.com/code360/problems/rotation_7449070

// You are given an array 'arr' having 'n' distinct integers sorted in ascending order. The array is right rotated 'r' times
// Find the minimum value of 'r'.

// Right rotating an array means shifting the element at 'ith' index to (‘i+1') mod 'n' index, for all 'i' from 0 to ‘n-1'.

// Input: 'n' = 5 , ‘arr’ = [3, 4, 5, 1, 2]
// Output: 3 
// Explanation: If we rotate the array [1 ,2, 3, 4, 5] right '3' times then we will get the 'arr'. Thus 'r' = 3.

public class CountRotations {

    public static int findKRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int idx = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    idx = low;
                    min = arr[low];
                }
                break;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    idx = low;
                }
                low = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    idx = mid;
                }
                high = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println(findKRotation(arr));
        // 3
    }
}
